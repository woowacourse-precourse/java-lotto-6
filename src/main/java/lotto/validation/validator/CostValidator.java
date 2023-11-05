package lotto.validation.validator;

import lotto.property.ErrorProperty;

import static lotto.property.LottoProperty.*;

public class CostValidator extends RootValidator{

    public static void CostIsStandardUnder(String inputPurchaseCost){
        Long purchaseCost = Long.parseLong(inputPurchaseCost);
        if (purchaseCost<COST_UNIT_STANDARD){
            throw new IllegalArgumentException(ErrorProperty.COST_IS_STATNDARD_UNDER.toString());
        }
    }
    public static void CostFormatIsCorrect(String inputPurchaseCost){
        Long purchaseCost = Long.parseLong(inputPurchaseCost);
        if (purchaseCost % COST_UNIT_STANDARD != COST_UNIT_TARGET){
            throw new IllegalArgumentException(ErrorProperty.COST_FORMAT_IS_NOT_CORRECT.toString());
        }
    }
}
