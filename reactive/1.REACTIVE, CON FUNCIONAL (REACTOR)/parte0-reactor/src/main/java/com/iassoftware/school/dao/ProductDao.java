package com.iassoftware.school.dao;

import com.iassoftware.school.models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductDao extends ReactiveMongoRepository<Product,String> {
}
