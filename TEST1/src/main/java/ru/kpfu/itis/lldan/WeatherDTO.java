package ru.kpfu.itis.lldan;

public class WeatherDTO {
    private String townName;
    private String temperature;
    private String humidity;
    private String precipitation;

    public WeatherDTO(String townName, String temperature, String humidity, String precipitation) {
        this.townName = townName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
