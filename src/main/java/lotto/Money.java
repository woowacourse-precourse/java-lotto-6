package lotto;


public class Money {
    private static final int LOTTO_MIN_MONEY = 1000;
    private static final int ZERO_NUMBER = 0;

    private final int money;

    public Money(int inputMoney) {
        validateMoney(inputMoney);
        this.money = inputMoney;
    }

    public int getTicketCount() {
        return money / LOTTO_MIN_MONEY;
    }


    private void validateMoney(int amount) {
        validatePositive(amount);
        validateRemainder(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= ZERO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRemainder(int amount) {
        if (amount % LOTTO_MIN_MONEY != ZERO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
