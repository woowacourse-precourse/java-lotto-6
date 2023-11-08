package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;

import static lotto.property.ValidationProperty.COST;
import static lotto.validation.ValidationForm.verifyFormatForInputValue;

public class Cost {
    private final Long purchaseCost;

    public Cost(String inputPurchaseCost) {
        this.purchaseCost = purchaseCostConvertToLong(inputPurchaseCost);
    }

    private Long purchaseCostConvertToLong(String inputPurchaseCost) {
        validate(inputPurchaseCost);
        return Long.parseLong(inputPurchaseCost);
    }

    private void validate(String inputPurchaseCost) {
        verifyFormatForInputValue(COST, inputPurchaseCost);
        if (inputPurchaseCost.length() > 10) {
            throw new IllegalArgumentException("너무 많음 금액을 입력하였습니다");
        }
    }

    public Long getPurchaseCost() {
        return (Long) FiledMapper.getFieldValue(this, MethodProperty.PURCHASE_COST);
    }
}
