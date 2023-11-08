package lotto.validate;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.constant.UtilsConstant;

public class ValidateInput {

    public static void validatePurchaseAmount(final String purchaseAmount) {
        validateIsEmpty(purchaseAmount);
        validateHasBlank(purchaseAmount);
        validateIsInteger(purchaseAmount);
        validateDivisible(purchaseAmount);
    }

    public static void validateWinningNumber(String inputNumber) {
        validateIsEmpty(inputNumber);
        validateHasBlank(inputNumber);
        List<String> inputString = List.of(inputNumber.split(UtilsConstant.DELIMITER.getString()));
        validateIsIntegerList(inputString);
    }

    public static void validateBonusNumber(String input) {
        validateIsEmpty(input);
        validateHasBlank(input);
        validateIsInteger(input);
    }

    private static void validateIsIntegerList(List<String> inputString) {
        try {
            inputString.forEach(Integer::parseInt);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE_INPUT_MESSAGE.getErrorMessage());
        }
    }

    private static void validateIsEmpty(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NON_EMPTY_MESSAGE.getErrorMessage());
        }
    }

    private static void validateHasBlank(final String purchaseAmount) {
        if (hasBlank(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NON_BLANK_MESSAGE.getErrorMessage());
        }
    }

    private static void validateIsInteger(final String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (final IllegalArgumentException error) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE_INPUT_MESSAGE.getErrorMessage());
        }
    }

    private static void validateDivisible(final String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        if (caculateRemainDivide(amount) != 0) {
            throw new IllegalArgumentException(ErrorMessage.CANNOT_DIVISIBLE_MESSAGE.getErrorMessage());
        }
    }

    private static boolean hasBlank(String purchaseAmount) {
        return purchaseAmount.contains(UtilsConstant.SINGLE_BLANK.getString());
    }

    private static int caculateRemainDivide(int amount) {
        return amount % LottoConstant.LOTTO_PRICE.getValue();
    }
}
