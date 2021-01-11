package com.bartoszhanuszkiewicz.ramapper.domain;

import java.util.Optional;

public class NumberToWordMapper {

    private final MapperKeyValueRepository mapperKeyValueRepository;

    public NumberToWordMapper(MapperKeyValueRepository mapperKeyValueRepository) {
        this.mapperKeyValueRepository = mapperKeyValueRepository;
    }

    public Optional<MappingResult> map(String mapperName, Integer numberToMap) {
        return mapperKeyValueRepository.getAllMappingsForMapperName(mapperName).stream()
                                       .filter(mapping -> mapping.mapperName() == mapperName)
                                       .findFirst()
                                       .map(MappingResult::from);
    }
}
