package self.fzh.web.controller;


import com.alibaba.fastjson.JSONObject;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import self.fzh.web.dao.Asset;
import self.fzh.web.domain.Option;
import self.fzh.web.mapper.AssetMapper;
import self.fzh.web.mapper.CustomerMapper;
import self.fzh.web.service.AssetService;
import self.fzh.web.vo.ChartRequestVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("asset")
public class AssetController {

    @Autowired
    private AssetMapper assetMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private AssetService assetService;


    /**
     * x轴的数据来自于对asset表的createtime去重排序
     * series的name以及option的legend来自对category去重
     * series的数据来自于单独查询category后的num数据按照时间进行排序
     * @param requestVO
     * @return
     */
    @PostMapping("api/test")
    public String test(@RequestBody ChartRequestVO requestVO){
        Option option = new Option();
        // legend and x
        List<String> categories = customerMapper.queryDistinctCategory();
        Option.Legend legend = new Option.Legend();
        legend.setData(categories);
        option.setLegend(legend);
        // x
        List<String> dates = customerMapper.queryDistinctDateOrderByTime();
        Option.Axis xAxis = new Option.Axis();
        xAxis.setType("category");
        xAxis.setData(dates);
        xAxis.setName("时间");
        option.setxAxis(xAxis);
        // y
        Option.Axis yAxis = new Option.Axis();
        yAxis.setType("value");
        yAxis.setName("金额");
        option.setyAxis(yAxis);
        // series
        List<Option.Axis> seriesList = new ArrayList<>();
        categories.forEach(category -> {
            Option.Axis series = new Option.Axis();
            series.setType("line");
            series.setName(category);
            List<Asset> seriesValues = assetService.queryAssetByCategory(category);
            List<String> seriesValueList = new ArrayList<>();
            seriesValues.forEach(seriesValue -> {
                seriesValueList.add(null == seriesValue.getNum() ? "0.0" : seriesValue.getNum().toString());
            });
            series.setData(seriesValueList);
            seriesList.add(series);
        });
        option.setSeries(seriesList);
        Option.Tooltip tooltip = new Option.Tooltip();
        tooltip.setTrigger("item");
        option.setTooltip(tooltip);
        return JSONObject.toJSONString(option);






    }
}
