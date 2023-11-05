package lotto.entity;

import lotto.property.ValidationProperty;
import lotto.validation.ValidationForm;

import java.lang.reflect.Field;

import static lotto.property.ValidationProperty.*;
import static lotto.validation.ValidationForm.*;

public class Cost {
    private final Long purchaseCost;

    public Cost(String inputPurchaseCost) {
        this.purchaseCost = purchaseCostConvertToLong(inputPurchaseCost);
    }

    private Long purchaseCostConvertToLong(String inputPurchaseCost){
        validate(inputPurchaseCost);
        return Long.parseLong(inputPurchaseCost);
    }

    private void validate(String inputPurchaseCost){
        verifyFormatForInputValue(COST,inputPurchaseCost);
    }

    public Long getFieldValue(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (Long) field.get(this);
    }
}
