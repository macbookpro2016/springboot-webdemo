package self.fzh.web.controller;


import com.alibaba.fastjson.JSONObject;
import org.checkerframework.checker.units.qual.A;
import org.springframework.web.bind.annotation.*;
import self.fzh.web.domain.Option;
import self.fzh.web.vo.ChartRequestVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("asset")
public class AssetController {


    @PostMapping("api/test")
    public String test(@RequestBody ChartRequestVO requestVO){
        Option option = new Option();
        Option.Axis xAxis = new Option.Axis();
        xAxis.setType("category");
        xAxis.setData(Arrays.asList("A", "B", "C"));
        option.setxAxis(xAxis);
        Option.Axis yAxis = new Option.Axis();
        yAxis.setType("value");
        option.setyAxis(yAxis);
        Option.Axis series1 = new Option.Axis();
        series1.setType("line");
        series1.setData(Arrays.asList("120", "200", "150"));
        List<Option.Axis> series = Arrays.asList(series1);
        option.setSeries(series);
        return JSONObject.toJSONString(option);
    }
}
