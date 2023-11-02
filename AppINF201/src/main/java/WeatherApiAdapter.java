import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

public interface WeatherApiAdapter {
    WeatherData getWeatherData(String location) throws IOException, SAXException, ParserConfigurationException;
}
