package com.employee.employeeAPI.Service;



import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class APICallerService {
    public Object apiCaller(URI url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(url).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

}
