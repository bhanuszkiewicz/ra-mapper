package com.bartoszhanuszkiewicz.ramapper.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MappingFacade {

    private final MappingService mappingService;

    MappingFacade(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    public List<MappingResult> calculateDivisorsAndMap(List<Integer> numbers, String mappingName) {
        return numbers
                .stream()
                .map(number -> mappingService.divideAndMap(number, mappingName).get())
                .collect(Collectors.toList());
    }
}
