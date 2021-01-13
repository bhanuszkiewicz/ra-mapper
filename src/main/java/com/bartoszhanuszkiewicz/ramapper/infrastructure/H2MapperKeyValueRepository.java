package com.bartoszhanuszkiewicz.ramapper.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import com.bartoszhanuszkiewicz.ramapper.domain.MapperKeyValue;
import com.bartoszhanuszkiewicz.ramapper.domain.MapperKeyValueRepository;

public class H2MapperKeyValueRepository implements MapperKeyValueRepository {

    private final MapperKeyValueDao mapperKeyValueDao;

    public H2MapperKeyValueRepository(MapperKeyValueDao mapperKeyValueDao) {
        this.mapperKeyValueDao = mapperKeyValueDao;
    }

    @Override
    public List<MapperKeyValue> getAllMappingsForMapperName(String mapperName) {
        return mapperKeyValueDao.findAllByMapperName(mapperName)
                                .stream()
                                .map(MapperKeyValueEntity::toDomainObject)
                                .collect(Collectors.toList());
    }
}
