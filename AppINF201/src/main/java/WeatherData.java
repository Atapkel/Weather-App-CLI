class WeatherData {
    private double temperature;
    private double humidity;
    private String weatherDescription;

    public WeatherData(double temperature, double humidity, String weatherDescription) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.weatherDescription = weatherDescription;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @Override
    public String toString() {
        return "Weather data \n" +
                "temperature=" + temperature +
                "\n humidity=" + humidity +
                "\n weatherDescription='" + weatherDescription + '\'';
    }
}
