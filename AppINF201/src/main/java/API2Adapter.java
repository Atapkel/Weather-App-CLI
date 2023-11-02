import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class API2Adapter implements WeatherApiAdapter {
    final String apiKey = "your api key";

    @Override
    public WeatherData getWeatherData(String city) throws IOException {
        String api = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "?unitGroup=metric&include=days&key=9UWWK2JCPUPAAGP3NP5K6H5D5&contentType=json";

        URL url = new URL(api);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Scanner reader = new Scanner(connection.getInputStream());
        String data = "";
        while (reader.hasNext()) {
            data += reader.nextLine();
        }
        JsonObject json = JsonParser.parseString(data).getAsJsonObject();
        double temperature = json.getAsJsonArray("days").get(0).getAsJsonObject().get("temp").getAsDouble();
        int humidity = json.getAsJsonArray("days").get(0).getAsJsonObject().get("humidity").getAsInt();

        String description = json.getAsJsonArray("days").get(0).getAsJsonObject().get("description").getAsString();

//        System.out.println(api);
//        System.out.println(data);
        WeatherData weatherData = new WeatherData(temperature, humidity, description);
        return weatherData;

    }
}
