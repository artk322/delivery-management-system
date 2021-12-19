package com.example.couriers_service;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class CouriersServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CouriersServiceApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate() {
    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setConnectTimeout(3000);
    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();

    credentialsProvider.setCredentials(AuthScope.ANY,
        new UsernamePasswordCredentials("rest-client", "p@ssword"));

    HttpClient client = HttpClientBuilder
        .create()
        .setDefaultCredentialsProvider(credentialsProvider)
        .build();

    requestFactory.setHttpClient(client);
    return new RestTemplate(requestFactory);
  }

}
