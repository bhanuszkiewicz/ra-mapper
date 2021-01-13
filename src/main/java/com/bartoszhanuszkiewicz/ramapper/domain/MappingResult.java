package com.bartoszhanuszkiewicz.ramapper.domain;

import java.util.List;

public class MappingResult {

    private Integer number;
    private List<String> mappings;

    MappingResult(Integer number, List<String> mappings) {
        this.number = number;
        this.mappings = mappings;
    }

    public Integer getNumber() {
        return number;
    }

    public List<String> getMappings() {
        return mappings;
    }
}
