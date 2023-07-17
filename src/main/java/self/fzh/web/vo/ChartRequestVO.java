package self.fzh.web.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class ChartRequestVO implements Serializable {

    private String type;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
