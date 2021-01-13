package com.bartoszhanuszkiewicz.ramapper.domain;

import java.util.List;

class MappingResult {

    private Integer number;
    private List<String> mappings;

    MappingResult(Integer number, List<String> mappings) {
        this.number = number;
        this.mappings = mappings;
    }

    public Integer number() {
        return number;
    }

    public List<String> mappings() {
        return mappings;
    }
}
