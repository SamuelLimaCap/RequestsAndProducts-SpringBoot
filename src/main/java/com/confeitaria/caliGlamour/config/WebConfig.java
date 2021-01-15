package com.confeitaria.caliGlamour.config;


import com.confeitaria.caliGlamour.entities.Product;
import com.confeitaria.caliGlamour.entities.Request;
import com.confeitaria.caliGlamour.entities.User;
import com.confeitaria.caliGlamour.repositories.ProductRepository;
import com.confeitaria.caliGlamour.repositories.RequestRepository;
import com.confeitaria.caliGlamour.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Array;
import java.util.Arrays;
import java.util.Optional;

@Configuration
@Profile("dev")
public class WebConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) {

        Product p1 = new Product(null,"ola",2);
        productRepository.save(p1);

    }

}
