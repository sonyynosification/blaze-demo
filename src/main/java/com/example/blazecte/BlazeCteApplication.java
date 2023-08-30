package com.example.blazecte;

import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableEntityViews

public class BlazeCteApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlazeCteApplication.class, args);
  }

//  @Bean
//  @Transactional
//  CommandLineRunner commandLineRunner(UserEntityRepository userEntityRepository, PostEntityRepository postEntityRepository) {
//    return args -> {
//      userEntityRepository.findAll()
//          .forEach(userEntity -> System.out.println(userEntity));
//      postEntityRepository.findAll()
//          .forEach(postEntity -> System.out.println(postEntity));
//    };
//  }

  @Bean
  CommandLineRunner commandLineRunner(UserRepository userRepository) {
    return args -> {
      userRepository.findAll(null, PageRequest.of(0, 3))
          .forEach(userEntity -> System.out.println(userEntity.getId() + " " + userEntity.getEmail() + " " + userEntity.getPosts()));
    };
  }
}
