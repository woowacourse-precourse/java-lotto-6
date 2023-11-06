package lotto.Domain;

public class LottoPurchaseAmountValidator {

    private final static String INVALID_TYPE_MESSAGE = "[ERROR] 숫자로 이루어진 값을 입력해주세요";
    private final static String INVALID_NUMBER_MESSAGE = "[ERROR] 올바른 금액을 입력해주세요";
    public static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_TYPE_MESSAGE);
            throw new IllegalArgumentException(INVALID_TYPE_MESSAGE);
        }
    }

    public static void validateFitPurchaseAmountCondition(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            System.out.println(INVALID_NUMBER_MESSAGE);
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }
}

