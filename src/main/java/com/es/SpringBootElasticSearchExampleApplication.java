package com.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.es.repository")
public class SpringBootElasticSearchExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticSearchExampleApplication.class, args);
	}

}
