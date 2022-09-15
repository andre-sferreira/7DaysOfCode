package br.com.asf.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class Application {
	
	public static void main(String[] args) throws IOException, InterruptedException {

		String apiKey = args[0].trim();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
				.version(HttpClient.Version.HTTP_2)
				.timeout(Duration.ofSeconds(30000))
				.GET()
				.build();

		HttpResponse<String> response = HttpClient.newBuilder()
				.build()
				.send(request, BodyHandlers.ofString());

		System.out.println(response.body());
			
	}

}
