package lotto.validation;

public class InputValidation {
    public int validatePurchaseAmount(String input) {
        validateInputIsNumeric(input);
        validateCheckRangeOfInput(input);
        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmountIsPositive(purchaseAmount);
        validatePurchaseAmountUnit(purchaseAmount);

        return purchaseAmount;
    }

    public void validateInputIsNumeric(String input) {
        if (!input.matches("[-+]?\\d*")) {
            throw new NumberFormatException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    public void validateCheckRangeOfInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 21억(2,100,000,000)이하로 입력해야 합니다.");
        }
    }

    public void validatePurchaseAmountIsPositive(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수로 입력해야 합니다.");
        }
    }

    public void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public void validateInputIsNull(String input) {
        if (input == null || input.equals("")) {
            throw new NullPointerException("[ERROR] 로또 구입 금액을 입력하세요.");
        }
    }
}
