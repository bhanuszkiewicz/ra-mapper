package com.bartoszhanuszkiewicz.ramapper.domain;

public class MappingResult {

    public static MappingResult from(MapperKeyValue mapperKeyValue) {
        return new MappingResult(mapperKeyValue.number(), mapperKeyValue.mapperName(), mapperKeyValue.mappedValue());
    }

    private Integer number;
    private String mapperName;
    private String mappedValue;

    private MappingResult(Integer number, String mapperName, String mappedValue) {
        this.number = number;
        this.mapperName = mapperName;
        this.mappedValue = mappedValue;
    }

    public Integer number() {
        return number;
    }

    public String mapperName() {
        return mapperName;
    }

    public String mappedValue() {
        return mappedValue;
    }
}
