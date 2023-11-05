package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;
import lotto.property.ValidationProperty;
import lotto.validation.ValidationForm;

import java.lang.reflect.Field;

import static lotto.property.ValidationProperty.*;
import static lotto.validation.ValidationForm.*;

public class Cost{
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

    public Long getPurchaseCost() {
        return (Long) FiledMapper.getFieldValue(this, MethodProperty.PURCHASE_COST);
    }
}
