package lotto.domain;

import lotto.validator.system.SystemValidator;

public class Budget {
    private final int budget;

    public Budget(String budget){
        SystemValidator.budgetValidator(toNumber(budget));
        this.budget = toNumber(budget);
    }


    private int toNumber(String budget){
        return Integer.parseInt(budget);
    }

    public int getBudget(){
        SystemValidator.budgetValidator(budget);
        return budget;
    }


}
