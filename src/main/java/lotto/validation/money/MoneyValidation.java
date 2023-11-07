package lotto.validation.money;

import lotto.validation.Validation;
import lotto.validation.ValidationCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoneyValidation implements Validation {
    private List<ValidationCondition> validationConditions = new ArrayList<>();

    public MoneyValidation(ValidationCondition... validationConditions){
        this.validationConditions = Arrays.asList(validationConditions);
    }

    @Override
    public void validate(String money) {
        // money가 1000으로 나누어 떨어지지 않은 경우 예외 발생
        for ( ValidationCondition each : validationConditions ) {
            each.isSatisfiedBy(money);
        }
    }

}
