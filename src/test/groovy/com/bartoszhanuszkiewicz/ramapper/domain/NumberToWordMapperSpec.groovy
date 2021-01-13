package com.bartoszhanuszkiewicz.ramapper.domain

import spock.lang.Specification

import static java.util.Collections.emptyList

class NumberToWordMapperSpec extends Specification{

    public static final String MAPPER_NAME = "Animals"
    public static final String MAPPER_1_VALUE = "Dog"
    public static final String MAPPER_2_VALUE = "Cat"
    private MapperKeyValueRepository mapperKeyValueRepository
    private NumberToWordMapper mapper

    def setup() {
        mapperKeyValueRepository = Mock()
        mapper = new NumberToWordMapper(mapperKeyValueRepository)
    }

    def "Should map number to words"() {
        given: "There are mappings in repository"
            mapperKeyValueRepository.getAllMappingsForMapperName(MAPPER_NAME) >> [anyMapperKeyValue(1, MAPPER_1_VALUE), anyMapperKeyValue(2, MAPPER_2_VALUE)]
        when: "Mapper is executed"
            def mappingResult = mapper.map(MAPPER_NAME, 2)
        then: "Mapper returned number with mapped words"
            assert mappingResult.isPresent()
            assert mappingResult.get() == MAPPER_2_VALUE
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

    private def anyMapperKeyValue(int number, String value) {
        new MapperKeyValue(number, MAPPER_NAME, value)
    }
}
