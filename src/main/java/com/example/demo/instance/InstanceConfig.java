package com.example.demo.instance;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstanceConfig {

    @Bean
    CommandLineRunner InstanceLineRunner(InstanceRepository repository){
        return args -> {
            Instance AC = new Instance(
                2024,
                1,
                1L
            );
            Instance DS = new Instance(
                2024,
                1,
                2L
            );
            Instance OS = new Instance(
                2022,
                5,
                1L
            );
            repository.saveAll(List.of(AC,DS,OS));
        };
    }
}
