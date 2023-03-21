package ru.netology;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class Main {

    public static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) {

//  Создайте метод в который добавьте и настройте класс CloseableHttpClient например с помощью builder
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build()) {

//  Добавьте объект запроса
//        HttpGet request = new HttpGet(URL);
//  Bызовите удаленный сервис
//        CloseableHttpResponse response = httpClient.execute(request)

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}