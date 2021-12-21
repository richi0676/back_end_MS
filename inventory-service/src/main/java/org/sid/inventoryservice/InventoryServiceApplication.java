package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

@Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
    repositoryRestConfiguration.exposeIdsFor(Product.class);
        return args -> {
          productRepository.save(new Product(null,"ordinateur",8895,15));
          productRepository.save(new Product(null,"imprimant",1000,50));
          productRepository.save(new Product(null,"SOURIS",80,100));
          productRepository.findAll().forEach(p->{
              System.out.println(p.getName());
          });
        };
    }
}
