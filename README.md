# weatherApp

weather app in Java that works in the terminal.
There I use an adapter pattern to connect my WeatherApp class to the Json of the OpenWeather and Visual Crossing.
In the code, you need to download the library of the JsonObject. Using JsonObject we will parse JSON files. On the HTTP requests.
In OpenWeather JSON is different than  Visual Crossing JSON. But in my code has a WeatherData class there several types of data like temperature,
humidity, and weather description data. I get the same data type from both API Sites using Adapter pattern. 

