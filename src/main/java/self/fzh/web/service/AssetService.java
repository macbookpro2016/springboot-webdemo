package self.fzh.web.service;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.fzh.web.dao.Asset;
import self.fzh.web.dao.AssetExample;
import self.fzh.web.mapper.AssetMapper;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetMapper assetMapper;

    public List<Asset> queryAssetByCategory(String category){
        AssetExample example = new AssetExample();
        AssetExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        example.setOrderByClause("create_time");
        return assetMapper.selectByExample(example);
    }
}
