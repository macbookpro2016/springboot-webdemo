package self.fzh.web.mapper;

import self.fzh.web.dao.Asset;

import java.util.List;

public interface CustomerMapper {

    public List<String> queryDistinctCategory();

    List<String> queryDistinctDateOrderByTime();


}
