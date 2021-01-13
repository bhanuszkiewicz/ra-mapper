package com.bartoszhanuszkiewicz.ramapper.domain;

import java.util.Optional;

class NumberToWordMapper {

    private final MapperKeyValueRepository mapperKeyValueRepository;

    NumberToWordMapper(MapperKeyValueRepository mapperKeyValueRepository) {
        this.mapperKeyValueRepository = mapperKeyValueRepository;
    }

    public Optional<String> map(String mapperName, Integer numberToMap) {
        return mapperKeyValueRepository.getAllMappingsForMapperName(mapperName).stream()
                                       .filter(mapping -> mapping.mapperName().equals(mapperName))
                                       .filter(mapping -> mapping.number().equals(numberToMap))
                                       .findFirst()
                                       .map(MapperKeyValue::mappedValue);
    }
}
