package com.bartoszhanuszkiewicz.ramapper.domain

import spock.lang.Specification
import spock.lang.Unroll

class DivisorsCalculatorSpec extends Specification {

    private DivisorsCalculator divisorsCalculator = new DivisorsCalculator()

    @Unroll
    def "Should return list of divisors for positive value"() {
        when: "Divisors calculator is executed for positive value"
            def divisors = divisorsCalculator.calculate(number)
        then: "List of divisors is correct"
            assert divisors.containsAll(expectedDivisors)
        where:
            number | expectedDivisors
            4      | [1, 2, 4]
            10     | [1, 2, 5, 10]
            100    | [1, 2, 4, 5, 10, 20, 25, 50, 100]
    }

    @Unroll
    def "Should return empty list of divisors for negative value"() {
        when: "Divisors calculator is executed for negative value"
            def divisors = divisorsCalculator.calculate(-10)
        then: "List of divisors is correct"
            assert divisors.empty
    }

    @Unroll
    def "Should return empty list of divisors for zero"() {
        when: "Divisors calculator is executed for negative value"
            def divisors = divisorsCalculator.calculate(0)
        then: "List of divisors is correct"
            assert divisors.empty
    }
}

