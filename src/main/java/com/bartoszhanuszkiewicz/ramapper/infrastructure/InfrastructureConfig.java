package com.bartoszhanuszkiewicz.ramapper.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bartoszhanuszkiewicz.ramapper.domain.MapperKeyValueRepository;

@Configuration
public class InfrastructureConfig {

    @Bean
    MapperKeyValueRepository mapperKeyValueRepository(MapperKeyValueDao mapperKeyValueDao){
        return new H2MapperKeyValueRepository(mapperKeyValueDao);
    }

    @Bean
    MapperKeyValueEntity mapperKeyValueEntity(){
        return new MapperKeyValueEntity();
    }
}
