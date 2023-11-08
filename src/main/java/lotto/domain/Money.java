package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE = "[ERROR] 1000으로 나누어지지 않는 금액입니다.";
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int userInput) throws IllegalArgumentException {
        if(userInput % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getTicket() {
        return money / LOTTO_PRICE;
    }
}
