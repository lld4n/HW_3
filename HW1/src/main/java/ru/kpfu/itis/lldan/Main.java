package ru.kpfu.itis.lldan;

public class Main {
    public static void main(String[] args) {
        System.out.println( HTTPClient.get("https://gorest.co.in/public/v2/users"));
        System.out.println(HTTPClient.post("https://gorest.co.in/public/v2/users","{\"name\":\"lldan\",\"email\":\"safinilfsdfsdaf@ffryn.test\",\"gender\":\"male\",\"status\":\"active\"}"));
        System.out.println(HTTPClient.put("https://gorest.co.in/public/v2/users/5115307", "{\"name\":\"lldan\",\"email\":\"safinilan@rya.test\",\"gender\":\"male\",\"status\":\"active\"}"));
        System.out.println(HTTPClient.delete("https://gorest.co.in/public/v2/users/5115307"));
    }
}