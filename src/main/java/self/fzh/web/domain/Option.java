package self.fzh.web.domain;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

public class Option implements Serializable {
    private Axis xAxis;
    private Axis yAxis;

    private Tooltip tooltip;

    private Legend legend;

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

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

        private String name;
        private List<String> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

    public static class Tooltip{
        private String trigger;
        private String formatter;

        public String getTrigger() {
            return trigger;
        }

        public void setTrigger(String trigger) {
            this.trigger = trigger;
        }

        public String getFormatter() {
            return formatter;
        }

        public void setFormatter(String formatter) {
            this.formatter = formatter;
        }
    }

    public static class Legend{
        private List<String> data;

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }
    }

}
