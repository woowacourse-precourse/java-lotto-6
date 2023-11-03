package lotto.validation;

public class InputValidation {
    public int validatePurchaseAmount(String input) {
        validateInputIsNumeric(input);
        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmountIsPositive(purchaseAmount);
        validatePurchaseAmountUnit(purchaseAmount);

        return purchaseAmount;
    }

    public void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public void validatePurchaseAmountIsPositive(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수로 입력해야 합니다.");
        }
    }

    public void validateInputIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NumberFormatException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }
}
