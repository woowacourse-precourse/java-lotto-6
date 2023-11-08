package lotto.domain;

public class Validator {

    private static final int UNIT = 1_000;
    private static final String nonNumericInputErrorMessage = "[ERROR] 숫자를 입력해주세요.";
    private static final String nonDivisibleUnitErrorMessgae = "[ERROR] 1,000원 단위로 입력해주세요.";
    private static final String moreAmountRequiredErroeMessage = "[ERROR] 1,000원 이상을 입력해주세요.";

    public static void validPurchaseAmount(String purchaseAmount) {
        int amount;
        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nonNumericInputErrorMessage);
        }

        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(nonDivisibleUnitErrorMessgae);
        }

        if (amount == 0) {
            throw new IllegalArgumentException(moreAmountRequiredErroeMessage);
        }
    }
}
