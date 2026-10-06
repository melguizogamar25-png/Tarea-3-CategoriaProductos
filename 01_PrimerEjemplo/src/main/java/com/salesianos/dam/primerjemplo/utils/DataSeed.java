package com.salesianos.dam.primerjemplo.utils;

import com.salesianos.dam.primerjemplo.model.Category;
import com.salesianos.dam.primerjemplo.model.Product;
import com.salesianos.dam.primerjemplo.repo.ProductRepository;
import com.salesianos.dam.primerjemplo.service.CategoryService;
import com.salesianos.dam.primerjemplo.service.ProductService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    @PostConstruct
    public void initData() {

        Category tecnologia = categoryService.addCategory(Category.builder().name("Tecnología").build());

        categoryService.addCategory(Category.builder().name("Deportes").build());

        productRepository.saveAll(List.of(
                Product.builder().name("Portátil 15 pulgadas").price(749.99)
                        .details("Portátil").category(tecnologia).build()
        ));
    }
}
