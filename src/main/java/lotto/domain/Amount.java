package lotto.domain;

public class Amount {
    private static final String NOT_DIVIDED_BY_PRICE_EXCEPTION_MESSAGE = "구입금액은 1000원 단위로 나누어떨어져야 합니다.";
    private static final String NOT_POSITIVE_EXCEPTION_MESSAGE = "구입금액은 양수여야 합니다.";
    private static final int LOTTO_PRICE = 1000;

    private final int amount;
    private final int numberOfLottos;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
        this.numberOfLottos = calculateNumberOfLottos(amount);
    }

    private void validate(final int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_EXCEPTION_MESSAGE);
        } else if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_PRICE_EXCEPTION_MESSAGE);
        }
    }

    private int calculateNumberOfLottos(final int amount) {
        return amount / LOTTO_PRICE;
    }
}
