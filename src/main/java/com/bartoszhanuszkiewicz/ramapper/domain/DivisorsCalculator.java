package com.bartoszhanuszkiewicz.ramapper.domain;

import java.util.ArrayList;
import java.util.List;

class DivisorsCalculator {

    public List<Integer> calculate(Integer number) {
        List<Integer> divisors = new ArrayList();
        for (int i = 1; i <= number; i++) {
            if(checkIfDivisor(number, i)) {
                divisors.add(i);
            }

        }
        return divisors;
    }

    private boolean checkIfDivisor(Integer number, int i) {
        return number % i == 0;
    }
}
