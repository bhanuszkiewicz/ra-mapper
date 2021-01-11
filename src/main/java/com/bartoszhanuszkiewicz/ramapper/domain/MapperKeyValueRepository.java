package com.bartoszhanuszkiewicz.ramapper.domain;

import java.util.List;

public interface MapperKeyValueRepository {

    List<MapperKeyValue> getAllMappingsForMapperName(String mapperName);
}
