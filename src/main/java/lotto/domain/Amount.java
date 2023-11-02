package lotto.domain;

public class Amount {

    private static final int ONE_LOTTO_PRICE = 1000;

    private final int amount;

    public Amount(int amount) {
        validateAmountRange(amount);
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount % ONE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력을 해야합니다.");
        }
    }

    private void validateAmountRange(int amount) {
        if (amount < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입은 1000원부터 가능합니다.");
        }
    }
}
