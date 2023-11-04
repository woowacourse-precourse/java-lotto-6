package lotto.validation.validator;

import lotto.property.ErrorProperty;

import static lotto.property.ErrorProperty.*;

public abstract class RootValidator {

    public static void valueIsEmpty(String value){
        if (value.isEmpty()){
            throw new IllegalArgumentException(VALUE_IS_EMPTY.toString());
        }
    }

    public static void valueContainsSpace(String value){
        String compareTarget = value.replaceAll(" ", "");
        if (!compareTarget.equals(value)){
            throw new IllegalArgumentException(VALUE_CONTATIN_SPACE.toString());
        }
    }
}
