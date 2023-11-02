import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city name : ");
        String cityName = sc.nextLine();
        System.out.println(cityName);
        WeatherApiAdapter ap1 = new API2Adapter();
        WeatherApiAdapter ap2 = new OpenWeatherAdapter();
        WeatherData d1 = ap1.getWeatherData(cityName);
        WeatherData d2 = ap2.getWeatherData(cityName);
        System.out.println("Data from Api 2 :" + d1);
        System.out.println();
        System.out.println();
        System.out.println("Data from Open Weather :" + d2);
    }
}