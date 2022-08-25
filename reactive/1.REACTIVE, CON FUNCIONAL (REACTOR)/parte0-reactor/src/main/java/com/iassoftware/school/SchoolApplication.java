package com.iassoftware.school;

import com.iassoftware.school.dao.ProductDao;
import com.iassoftware.school.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {

	@Autowired
	private ProductDao dao;
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
private static final Logger log = LoggerFactory.getLogger(SchoolApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.dropCollection("product").subscribe();

		Flux.just(new Product("Tv panasonic pantalla LCD",445.766),
				new Product("Apple ipod",145.766),
				new Product("Sony notebook",145.766))
				.flatMap(product ->{ product.setCreateAt(new Date());
	             return dao.save(product);})
				.subscribe(product -> log.info("Insert: "+ product.getId()+" "+product.getName()));
	}
}
