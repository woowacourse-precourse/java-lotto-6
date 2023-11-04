package lotto.domain;

public class PurchaseAmounts {
    private final String VALIDATE_NUMBER_CODE = "-?\\\\d+";
    private final int LOTTO_PRICE = 1000;

    private int purchaseAmounts;

    public PurchaseAmounts(String userInput) {
        int parsingUserInput = parsingPurchaseAmounts(userInput);
        validatePurchaseAmounts(parsingUserInput);
        this.purchaseAmounts = parsingUserInput;
    }

    private int parsingPurchaseAmounts(String userInput) {
        if (!userInput.matches(VALIDATE_NUMBER_CODE)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다. 다시 입력해주세요.");
        }
        return Integer.parseInt(userInput);
    }

    private void validatePurchaseAmounts(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 장당 1000원 입니다. 다시 입력해주세요.");
        }
    }
}
