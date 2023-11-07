package lotto.domain.money;

public class Money {
    private static final long LOTTO_COST = 1_000;
    private static final long MAX_LIMIT = 1_000_000_000;
    private final long money;

    public Money(long money) {
        this.money = money;
        validateMoney();
    }

    public void validateMoney() {
        validateMoneyIsMoreThanThousand();
        validateMoneyDividedByThousand();
    }

    private void validateMoneyIsMoreThanThousand() {
        if(money < LOTTO_COST) {
            throw new IllegalArgumentException("1000원 이상 입금");
        }
    }

    private void validateMoneyLessThanLongMax() {
        if(money >= MAX_LIMIT) {
            throw new IllegalArgumentException("10억원 미만 구매");
        }
    }

    private void validateMoneyDividedByThousand() {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("돈은 1000원 단위로 나누어 져야 함");
        }
    }

    public long getNumberOfTheLotto() {
        return money / LOTTO_COST;
    }

    public long getMoney() {
        return money;
    }
}
