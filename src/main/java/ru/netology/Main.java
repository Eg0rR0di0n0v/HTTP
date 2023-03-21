package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    private static final ObjectMapper map = new  ObjectMapper();
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
            HttpGet request = new HttpGet(URL);
//  Bызовите удаленный сервис
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                {

//                    Программа должна прочитать весь список и вернуть только те факты, у которых поле upvotes не равно null или нулю.
                    List<Facts> responseList = map.readValue(response.getEntity().getContent(), new TypeReference<>() {
                    });

                    filter(responseList, i -> i.getUpvotes() == 0);
                    responseList.forEach(System.out::println);
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void filter(List<T> list, Predicate<T> predicate){
        Set<T> toRemove = list.stream().filter(predicate).collect(Collectors.toSet());
        list.removeAll(toRemove);
    }
}