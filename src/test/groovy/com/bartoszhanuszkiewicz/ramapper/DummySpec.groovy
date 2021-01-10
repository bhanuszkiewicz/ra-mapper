package com.bartoszhanuszkiewicz.ramapper

import spock.lang.Specification

class DummyTest extends Specification{

    def "Should return correct result for 2 + 2 "() {
        when: "Equation is executed"
            def result = 2 + 2
        then: "Result is 4"
          assert result == 4
    }
}
