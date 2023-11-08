package lotto;

import java.util.List;

public class LottoAmount {

    private static int amount;

    public LottoAmount(int amount) {
        validate(amount);
        validateDivisible(amount);
        validateNumber(String.valueOf(amount));

        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0원 초과이어야 합니다.");
        }
    }

    private void validateDivisible(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }

    }

    public int validateNumber(String amount) {
        boolean isDigit = amount.chars().allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException("[ERROR] 숫자로만 입력하세요.");

        }
        return Integer.parseInt(amount);
    }

    public int calculateLottoCount() {
        return amount / 1000;
    }

}
