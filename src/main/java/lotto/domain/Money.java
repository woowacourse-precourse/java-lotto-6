package lotto.domain;

public class Money {

    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateZero(money);
        validateDivideMoney(money);
    }

    private void validateZero(int inputMoney) {
        if(inputMoney == ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivideMoney(int inputMoney) {
        if(inputMoney % THOUSAND != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getTicket() {
        return money / 1000;
    }

}
