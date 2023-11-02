import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OpenWeatherAdapter implements WeatherApiAdapter {

    final String apiKey = "your api key";

    @Override
    public WeatherData getWeatherData(String city) throws IOException {
        String api = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        URL url = new URL(api);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Scanner reader = new Scanner(connection.getInputStream());
        String data = "";
        while (reader.hasNext()) {
            data += reader.nextLine();
        }
        JsonObject jsonObject = JsonParser.parseString(data).getAsJsonObject();
        double temperature = jsonObject.getAsJsonObject("main").get("temp").getAsDouble() - 273;
        int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
        String description = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
//        System.out.println(temperature+" "+description+" "+ humidity);
//        System.out.println("open Wether"+api);

        WeatherData weatherData = new WeatherData(temperature, humidity, description);
        return weatherData;
    }
}
