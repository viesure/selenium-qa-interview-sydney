package api.model;

public class APIResponse  {
    private String city;
    private String condition;
    private String icon;
    private String description;
    private weather weather;

    public APIResponse() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public api.model.weather getWeather() {
        return weather;
    }

    public void setWeather(api.model.weather weather) {
        this.weather = weather;
    }
}
