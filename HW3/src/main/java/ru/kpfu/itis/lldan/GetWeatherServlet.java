
package ru.kpfu.itis.lldan;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "getWeatherServlet", urlPatterns = "/getweather")
public class GetWeatherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("getweather.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String townName = req.getParameter("town");

        Map<String, String> weatherAttributes = getWeather(townName);
        req.setAttribute("townName", townName);
        weatherAttributes.forEach(req::setAttribute);
        req.getRequestDispatcher("weather.ftl").forward(req, resp);
    }

    public static Map<String, String> getWeather(String town) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://api.openweathermap.org/data/2.5/weather?q=" + town + "&appid=143c9d8999112b2f489a1e3a44de6ade").openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String input;
            while ((input = reader.readLine()) != null) {
                content.append(input);
            }
        }
        connection.disconnect();
        JsonObject weatherJson = JsonParser.parseString(content.toString()).getAsJsonObject();
        JsonObject currentWeather = weatherJson.get("main").getAsJsonObject();
        JsonElement temperature = currentWeather.get("temp");
        JsonElement humidity = currentWeather.get("humidity");
        JsonElement precipitation = weatherJson.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description");
        Map<String, String> weather = new HashMap<>();
        weather.put("temperature", new DecimalFormat("#0.00").format(Double.parseDouble(temperature.getAsString()) - 273) + " °C");
        weather.put("humidity", humidity.getAsString() + "%");
        weather.put("precipitation", precipitation.getAsString());
        return weather;
    }

}
