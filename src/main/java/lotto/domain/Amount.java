package lotto.domain;

public class Amount {

    private int amount;

    public Amount(Integer amount) {
        validateDividedByLottoPrice(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validateDividedByLottoPrice(Integer amount) {
        if (amount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
