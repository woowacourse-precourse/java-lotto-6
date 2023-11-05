package lotto;

public class LottoAmount {
    private static final String ONLY_DIVISIBLE_BY_THOUSAND = "[ERROR] 구입 금액은 1000원 단위로 입력해주세요.";
    private int amount;

    public LottoAmount(int money) {
        validateDivisibleByThousand(money);
        this.amount = money;
    }

    private void validateDivisibleByThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ONLY_DIVISIBLE_BY_THOUSAND);
        }
    }
}
