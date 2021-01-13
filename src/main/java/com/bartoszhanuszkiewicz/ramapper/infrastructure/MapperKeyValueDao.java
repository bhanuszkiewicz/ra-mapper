package com.bartoszhanuszkiewicz.ramapper.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MapperKeyValueDao extends JpaRepository<MapperKeyValueEntity, Long> {

    List<MapperKeyValueEntity> findAllByMapperName(String mapperName);
}
