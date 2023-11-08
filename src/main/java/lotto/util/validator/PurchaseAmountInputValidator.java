package lotto.util.validator;

import lotto.model.constant.PurchaseAmountConstants;
import lotto.util.validator.constant.ErrorMessageConstant;

public class PurchaseAmountInputValidator implements InputValidator{
    @Override
    public void validate(String checkValue) {
        validateNumber(checkValue);
        validateDivisibleThousand(checkValue);
        validatePositiveNumber(checkValue);
    }

    private static void validateNumber(String checkValue) {
        try{
            int number = Integer.parseInt(checkValue);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.PURCHASE_AMOUNT_IS_NOT_NUMERIC.getMessage());
        }
    }

    private static void validateDivisibleThousand(String checkValue) {
        if(Integer.parseInt(checkValue) % PurchaseAmountConstants.PURCHASE_AMOUNT_UNIT.getNumber() != PurchaseAmountConstants.DIVISIBLE_THOUSAND.getNumber()) {
            throw new IllegalArgumentException(ErrorMessageConstant.PURCHASE_AMOUNT_IS_NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }

    private static void validatePositiveNumber(String checkValue) {
        if(Integer.parseInt(checkValue) < PurchaseAmountConstants.POSITIVE_BENCHMARK.getNumber()) {
            throw new IllegalArgumentException(ErrorMessageConstant.PURCHASE_AMOUNT_IS_NOT_POSITIVE_NUMBER.getMessage());
        }
    }
}
