package com.bartoszhanuszkiewicz.ramapper.infrastructure

import com.bartoszhanuszkiewicz.ramapper.BaseIntegrationSpec
import com.bartoszhanuszkiewicz.ramapper.domain.MappingFacade
import org.springframework.beans.factory.annotation.Autowired

class MappingControllerIntegrationTest extends BaseIntegrationSpec {

    @Autowired
    private MappingFacade mapingFacade

    @Autowired
    private MapperKeyValueDao mapperKeyValueDao

    def "Should calculate divisors for list of numbers and map them to words"() {
        given: "There is a mapping key values in repository"
            mapperKeyValueDao.save(new MapperKeyValueEntity("Animals", 1, "Sheep"))
            mapperKeyValueDao.save(new MapperKeyValueEntity("Animals", 2, "Turkey"))
            mapperKeyValueDao.save(new MapperKeyValueEntity("Animals", 4, "Lamb"))
            mapperKeyValueDao.save(new MapperKeyValueEntity("Furniture", 2, "Table"))
            mapperKeyValueDao.save(new MapperKeyValueEntity("Plants", 4, "Tree"))
        when: "Calculate divisors and map them"
            def results = mapingFacade.calculateDivisorsAndMap([2], "Animals")
        then: "Numbers have calculated "
            assert results.size() == 1
            assert results[0].getNumber() == 2
            assert results[0].getMappings().containsAll(["Sheep", "Turkey"])
    }
}
