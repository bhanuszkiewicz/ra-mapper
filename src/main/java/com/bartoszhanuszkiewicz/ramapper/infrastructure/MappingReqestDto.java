package com.bartoszhanuszkiewicz.ramapper.infrastructure;

import java.util.List;

public class MappingReqestDto {

    private List<Integer> numbers;

    public MappingReqestDto() {
    }

    public MappingReqestDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
