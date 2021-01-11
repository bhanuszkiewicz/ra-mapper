package com.bartoszhanuszkiewicz.ramapper.domain;

public class MapperKeyValue {

    private Integer number;
    private String mapperName;
    private String mappedValue;

    public MapperKeyValue(Integer number, String mapperName, String mappedValue) {
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
