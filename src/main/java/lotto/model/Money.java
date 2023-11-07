package lotto.model;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private static final String INPUT_MONEY_MORE_THAN_ZERO = "[ERROR] 로또 구입 금액은 0원보다 많아야 합니다.";
    private static final String INPUT_DIVEDE_BY_THOUSAND = "[ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다.";
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getLottoCount() {
        return money / THOUSAND;
    }

    private void validateMoney(int inputBuyAccount) {
        validateMoreThanZero(inputBuyAccount);
        validateDivideByThousand(inputBuyAccount);
    }

    private void validateMoreThanZero(int inputBuyAccount) {
        if (inputBuyAccount <= ZERO) {
            throw new IllegalArgumentException(INPUT_MONEY_MORE_THAN_ZERO);
        }
    }

    private void validateDivideByThousand(int inputBuyAccount) {
        if (inputBuyAccount % THOUSAND != ZERO) {
            throw new IllegalArgumentException(INPUT_DIVEDE_BY_THOUSAND);
        }
    }
}