package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String WHITE_SPACE = " ";
    private static final String VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE = "[ERROR] 공백이 없는 값이어야 합니다.";
    private static final String VALIDATE_STRING_TO_INT_MESSAGE = "[ERROR] 입력 값은 숫자여야 합니다.";
    private static final String VALIDATE_PURCHASE_AMOUNT_RANGE_MESSAGE = "[ERROR] 입력 값은 1,000이상, 1,000,000이하의 숫자여야 합니다.";
    private static final String VALIDATE_THOUSAND_MULTIPLE_MESSAGE = "[ERROR] 입력 값은 1,000의 배수여야 합니다.";
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 10000000;

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validateContainWhiteSpace(purchaseAmount);
        validateStringToInt(purchaseAmount);
        validatePurchaseAmountRange(Integer.parseInt(purchaseAmount));
        validateThousandMultiple(Integer.parseInt(purchaseAmount));
    }

    public void validateContainWhiteSpace(String purchaseAmount) {
        if (purchaseAmount.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException(VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE);
        }
    }

    public void validateStringToInt(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_STRING_TO_INT_MESSAGE);
        }
    }

    public void validatePurchaseAmountRange(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT || purchaseAmount > MAX_PURCHASE_AMOUNT)
            throw new IllegalArgumentException(VALIDATE_PURCHASE_AMOUNT_RANGE_MESSAGE);
    }

    public void validateThousandMultiple(int purchaseAmount) {
        if (purchaseAmount % MIN_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(VALIDATE_THOUSAND_MULTIPLE_MESSAGE);
        }
    }
}
