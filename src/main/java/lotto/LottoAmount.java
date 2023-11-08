package lotto;

import java.util.List;

public class LottoAmount {

    private static int amount;

    public LottoAmount(int amount) {
        validate(amount);
        validateDivisible(amount);

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

    public int calculateLottoCount() {
        return amount / 1000;
    }

}
