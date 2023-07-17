package self.fzh.web.domain;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

public class Option implements Serializable {
    private Axis xAxis;
    private Axis yAxis;

    private List<Axis> series;

    public Axis getxAxis() {
        return xAxis;
    }

    public void setxAxis(Axis xAxis) {
        this.xAxis = xAxis;
    }

    public Axis getyAxis() {
        return yAxis;
    }

    public void setyAxis(Axis yAxis) {
        this.yAxis = yAxis;
    }

    public List<Axis> getSeries() {
        return series;
    }

    public void setSeries(List<Axis> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public static class Axis{
        private String type;
        private List<String> data;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }

}
