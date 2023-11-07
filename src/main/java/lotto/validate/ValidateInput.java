package lotto.validate;

import java.util.List;

public class ValidateInput {

    private static final String SINGLE_BLANK_INPUT = " ";
    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";
    private static final String NON_EMPTY_MESSAGE = "[ERROR] 값을 입력해주세요.";
    private static final String NON_BLANK_MESSAGE = "[ERROR] 비어있는 값은 입력할 수 없습니다.";
    private static final String WRONG_TYPE_INPUT_MESSAGE = "[ERROR] 정수형태로 입력해주세요";
    private static final String CANNOT_DIVISIBLE_MESSAGE = "[ERROR] 금액을 " + LOTTO_PRICE + "원 단위로 나눌 수 없습니다.";

    public static void validatePurchaseAmount(final String purchaseAmount) {
        validateIsEmpty(purchaseAmount);
        validateHasBlank(purchaseAmount);
        validateIsInteger(purchaseAmount);
        validateDivisible(purchaseAmount);
    }

    public static void validateWinningNumber(String inputNumber) {
        validateIsEmpty(inputNumber);
        validateHasBlank(inputNumber);
        List<String> inputString = List.of(inputNumber.split(DELIMITER));
        validateIsIntegerList(inputString);
    }

    private static void validateIsIntegerList(List<String> inputString) {
        try {
            inputString.forEach(Integer::parseInt);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(WRONG_TYPE_INPUT_MESSAGE);
        }
    }

    private static void validateIsEmpty(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(NON_EMPTY_MESSAGE);
        }
    }

    private static void validateHasBlank(final String purchaseAmount) {
        if (hasBlank(purchaseAmount)) {
            throw new IllegalArgumentException(NON_BLANK_MESSAGE);
        }
    }

    private static void validateIsInteger(final String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (final IllegalArgumentException error) {
            throw new IllegalArgumentException(WRONG_TYPE_INPUT_MESSAGE);
        }
    }

    private static void validateDivisible(final String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        if (remainDivide(amount) != 0) {
            throw new IllegalArgumentException(CANNOT_DIVISIBLE_MESSAGE);
        }
    }

    private static boolean hasBlank(String purchaseAmount) {
        return purchaseAmount.contains(SINGLE_BLANK_INPUT);
    }

    private static int remainDivide(int amount) {
        return amount % LOTTO_PRICE;
    }
}
