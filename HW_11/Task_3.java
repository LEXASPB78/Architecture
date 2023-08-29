package HW_11;

// Описание запроса GET: Определите функциональность API Gateway:

import java.net.HttpURLConnection;
import java.net.URL;

public class APIGatewayFunctionality {
    public static void main(String[] args) {
        try {
            // Создание URL-адреса запроса
            URL url = new URL("https://api-gateway-url.com");

            // Создание объекта HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Установка метода запроса
            connection.setRequestMethod("GET");

            // Получение кода ответа
            int responseCode = connection.getResponseCode();

            // Проверка кода ответа
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("API Gateway is functioning properly.");
            } else {
                System.out.println("API Gateway is not working properly. Response Code: " + responseCode);
            }

            // Закрытие соединения
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}