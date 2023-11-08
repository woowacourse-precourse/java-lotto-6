package lotto.validation;

import java.util.Arrays;
import java.util.List;

public class Validation {
    protected List<ValidationCondition> validationConditions;

    public Validation(ValidationCondition... validationConditions){
        this.validationConditions = Arrays.asList(validationConditions);
    }

    public void validate(Object object){
        for (ValidationCondition condition : validationConditions) {
            condition.isSatisfiedBy(object);
        }
    }

}
