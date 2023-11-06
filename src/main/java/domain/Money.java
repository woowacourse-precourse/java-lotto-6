package domain;

import constant.ConstantNumber;
import constant.ExceptionMessage;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getTicketCount() {
        return money / ConstantNumber.LOTTO_TICKET_COST.get();
    }

    private void validateMoney(int money) {
        if (money < ConstantNumber.LOTTO_TICKET_COST.get()) {
            throw new IllegalArgumentException(ExceptionMessage.LESS_MONEY_THAN_THE_TICKET_PRICE.get());
        }
        if (money % ConstantNumber.LOTTO_TICKET_COST.get() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_OTHER_THAN_PRICE_UNIT.get());
        }
    }

    public double getRateOfReturn(int sumOfWinningPrize) {
        validateMoney();
        return (double) sumOfWinningPrize / money * 100;
    }

    private void validateMoney() {
        if (money <= 0) {
            throw new RuntimeException(ExceptionMessage.MONEY_AMOUNT_IS_NEGATIVE.get());
        }
    }
}
