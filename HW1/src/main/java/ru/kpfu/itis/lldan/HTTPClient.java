package ru.kpfu.itis.lldan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HTTPClient {


    public static String get(String url) {
        try {
            HttpURLConnection connection = createConnection(url, "GET");
            return readResponse(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String url, Map<String, String> params) {
        if (params != null && !params.isEmpty()) {
            StringBuilder paramBuilder = new StringBuilder(url);
            paramBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                paramBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = paramBuilder.toString();
        }

        try {
            HttpURLConnection connection = createConnection(url, "GET");

            return readResponse(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String post(String url, String jsonBody) {
        try {
            HttpURLConnection connection = createConnection(url, "POST");
            writeRequestBody(connection, jsonBody);

            return readResponse(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String put(String url, String jsonBody) {
        try {
            HttpURLConnection connection = createConnection(url, "PUT");
            writeRequestBody(connection, jsonBody);

            return readResponse(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String delete(String url) {
        try {
            HttpURLConnection connection = createConnection(url, "DELETE");

            return readResponse(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeRequestBody(HttpURLConnection connection, String jsonBody) throws IOException {
        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);
        }
    }


    private static HttpURLConnection createConnection(String url, String method) throws IOException {
        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer ba40ab00d0becc03907e486c076d73a3dbee86988ee55ec1e9464b67195d33ad");
        connection.setDoOutput(true);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        return connection;
    }


    private static String readResponse(HttpURLConnection connection) throws IOException {
        System.out.println(connection.getResponseCode());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String input;
            while ((input = reader.readLine()) != null) {
                content.append(input);
            }
            return content.toString();
        }
    }
}
