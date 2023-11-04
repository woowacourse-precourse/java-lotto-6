package lotto.validation.validator;

import lotto.property.ErrorProperty;

import static lotto.property.ErrorProperty.*;

public abstract class RootValidator {

    public static void valueIsEmpty(String value){
        if (value.isEmpty()){
            throw new IllegalArgumentException(VALUE_IS_EMPTY.toString());
        }
    }
}
