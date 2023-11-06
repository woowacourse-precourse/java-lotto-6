package lotto.domain;


import lotto.validation.CostValidator;

public class Cost {
    private final int number;

    public Cost(int number) {
        CostValidator.validateParsedCost(number);
        this.number = number;
    }
}
