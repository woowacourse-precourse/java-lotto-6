package lotto.util.validator;

import lotto.model.constant.ParchaseAmountConstants;
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
        if(Integer.parseInt(checkValue) % ParchaseAmountConstants.PARCHASE_AMOUNT_UNIT.getNumber() != ParchaseAmountConstants.DIVISIBLE_THOUSAND.getNumber()) {
            throw new IllegalArgumentException(ErrorMessageConstant.PURCHASE_AMOUNT_IS_NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }

    private static void validatePositiveNumber(String checkValue) {
        if(Integer.parseInt(checkValue) < ParchaseAmountConstants.POSITIVE_BENCHMARK.getNumber()) {
            throw new IllegalArgumentException(ErrorMessageConstant.PURCHASE_AMOUNT_IS_NOT_POSITIVE_NUMBER.getMessage());
        }
    }
}
