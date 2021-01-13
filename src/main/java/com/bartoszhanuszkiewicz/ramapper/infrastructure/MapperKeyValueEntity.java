package com.bartoszhanuszkiewicz.ramapper.infrastructure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bartoszhanuszkiewicz.ramapper.domain.MapperKeyValue;

@Entity
@Table(name = "mapping_key_value")
public class MapperKeyValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mapperName;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private String value;

    public MapperKeyValueEntity() {
    }

    MapperKeyValueEntity(String mapperName, Integer number, String value) {
        this.mapperName = mapperName;
        this.number = number;
        this.value = value;
    }

    MapperKeyValue toDomainObject(){
        return new MapperKeyValue(number, mapperName, value);
    }
}
