package com.bartoszhanuszkiewicz.ramapper.domain

import spock.lang.Specification

import static java.util.Collections.emptyList

class NumberToWordMapperSpec extends Specification{

    public static final String MAPPER_NAME = "Animals"
    public static final String MAPPER_1_VALUE = "Dog"
    private MapperKeyValueRepository mapperKeyValueRepository
    private NumberToWordMapper mapper

    def setup() {
        mapperKeyValueRepository = Mock()
        mapper = new NumberToWordMapper(mapperKeyValueRepository)
    }

    def "Should map number to words"() {
        given: "There is given number"
            def givenNumber =  1
        and: "There are mappings in repository"
            mapperKeyValueRepository.getAllMappingsForMapperName(MAPPER_NAME) >> [anyMapperKeyValue(givenNumber)]
        when: "Mapper is executed"
            def mappingResult = mapper.map(MAPPER_NAME, givenNumber)
        then: "Mapper returned number with mapped words"
            assert mappingResult.isPresent()
            assert mappingResult.get().number() == givenNumber
            assert mappingResult.get().mapperName() ==  MAPPER_NAME
            assert mappingResult.get().mappedValue() == MAPPER_1_VALUE
    }

    def "Should not return result when there is no mappings for number"() {
        given: "There is given number"
            def givenNumber =  1
        and: "There are no mappings in repository"
            mapperKeyValueRepository.getAllMappingsForMapperName(MAPPER_NAME) >> emptyList()
        when: "Mapper is executed"
            def mappingResult = mapper.map(MAPPER_NAME, givenNumber)
        then: "Mapper not returned result"
            assert !mappingResult.isPresent()
    }

    private def anyMapperKeyValue(int number) {
        new MapperKeyValue(number, MAPPER_NAME, MAPPER_1_VALUE)
    }
}
