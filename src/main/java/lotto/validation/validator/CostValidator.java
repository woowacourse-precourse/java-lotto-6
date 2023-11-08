package lotto.validation.validator;

import lotto.property.ErrorProperty;

import static lotto.property.LottoProperty.COST_UNIT_STANDARD;
import static lotto.property.LottoProperty.COST_UNIT_TARGET;

public class CostValidator extends RootValidator {

    public static void costIsStandardUnder(String inputPurchaseCost) {
        Long purchaseCost = Long.parseLong(inputPurchaseCost);
        if (purchaseCost < COST_UNIT_STANDARD) {
            throw new IllegalArgumentException(ErrorProperty.COST_IS_STANDARD_UNDER.toString());
        }
    }

    public static void costFormatIsCorrect(String inputPurchaseCost) {
        Long purchaseCost = Long.parseLong(inputPurchaseCost);
        if (purchaseCost % COST_UNIT_STANDARD != COST_UNIT_TARGET) {
            throw new IllegalArgumentException(ErrorProperty.COST_FORMAT_IS_NOT_CORRECT.toString());
        }
    }
}
