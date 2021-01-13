package com.bartoszhanuszkiewicz.ramapper.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class MappingService {

    private final NumberToWordMapper mapper;
    private final DivisorsCalculator divisorsCalculator;

    MappingService(NumberToWordMapper mapper, DivisorsCalculator divisorsCalculator) {
        this.mapper = mapper;
        this.divisorsCalculator = divisorsCalculator;
    }

    public Optional<MappingResult> divideAndMap(Integer number, String mappingName) {
        return Optional.of(new MappingResult(number, calculateDivisorsAndMap(number, mappingName)));
    }

    private List<String> calculateDivisorsAndMap(Integer number, String mappingName) {
        return divisorsCalculator.calculate(number).stream()
                          .map(divisor -> mapper.map(mappingName, divisor).orElse("THERE_IS_NO_MAPPING"))
                          .collect(Collectors.toList());
    }
}
