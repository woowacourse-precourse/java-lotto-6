package lotto.domain;

public class Money {
    private static final String MONEY_NOT_UNDER_ONE_LOTTO_ERROR = "로또 구입 금액은 1000원 이상이어야 합니다";
    private static final String MONEY_NOT_MULTIPLE_OF_EACH_LOTTO = "로또 구입 금액은 1000원 단위로 입력해주세요";
    public static final int EACH_LOTTO = 1000;
    private static final int ZERO = 0;

    private final int amount;

    public Money(int amount) {
        if (amount < EACH_LOTTO) {
            throw new IllegalArgumentException(MONEY_NOT_UNDER_ONE_LOTTO_ERROR);
        }

        if (amount % EACH_LOTTO != ZERO) {
            throw new IllegalArgumentException(MONEY_NOT_MULTIPLE_OF_EACH_LOTTO);
        }

        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / EACH_LOTTO;
    }

}
