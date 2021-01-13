package com.bartoszhanuszkiewicz.ramapper.domain

import spock.lang.Specification

class MappingServiceSpec extends Specification {

    private MappingService mappingService
    private NumberToWordMapper numberToWordMapper
    private DivisorsCalculator divisorsCalculator = new DivisorsCalculator()


    def setup() {
        numberToWordMapper = Mock()
        mappingService = new MappingService(numberToWordMapper, divisorsCalculator)
    }

    def "Should return number and mappings for all divisors"() {
        given: "There is mappings"
            numberToWordMapper.map("Animals", 1) >> Optional.of("Dog")
            numberToWordMapper.map("Plants", 1) >> Optional.of("Flower")
            numberToWordMapper.map("Animals", 2) >> Optional.of("Cat")
            numberToWordMapper.map("Plants", 2) >> Optional.of("Tree")
        when: "Mapping is executed"
            def mappedValue = mappingService.divideAndMap(2, "Animals")
        then: "Number with mappings for divisors are correct"
            assert mappedValue.isPresent()
            assert mappedValue.get().number() == 2
            assert mappedValue.get().mappings().containsAll(["Dog", "Cat"])
    }
}
