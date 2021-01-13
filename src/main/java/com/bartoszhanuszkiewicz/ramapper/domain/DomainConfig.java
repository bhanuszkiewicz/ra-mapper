package com.bartoszhanuszkiewicz.ramapper.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    MappingFacade mappingFacade(MappingService mappingService){
        return new MappingFacade(mappingService);
    }

    @Bean
    MappingService mappingService(NumberToWordMapper numberToWorldMapper, DivisorsCalculator divisorsCalculator){
        return new MappingService(numberToWorldMapper, divisorsCalculator);
    }

    @Bean
    NumberToWordMapper numberToWordMapper(MapperKeyValueRepository mapperKeyValueRepository){
        return new NumberToWordMapper(mapperKeyValueRepository);
    }

    @Bean
    DivisorsCalculator divisorsCalculator() {
        return new DivisorsCalculator();
    }
}
