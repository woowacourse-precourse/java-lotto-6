package lotto.model;

import lotto.enums.Bounds;
import lotto.enums.Message;

public class Money {
    private final int money;

    public Money(String money) {
        validateMoneyIsNumber(money);
        int parsedMoney = Integer.parseInt(money);
        validateMoneyDividedByPrice(parsedMoney);
        this.money = parsedMoney;
    }

    public int getLottoAmount() {
        return money / Bounds.LOTTO_PRICE.getValue();
    }

    public double calculateReturnRate(long totalPrize) {
        return ((double) totalPrize / money) * 100;
    }

    private void validateMoneyIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_INPUT_MONEY_IS_NOT_NUMBER
                    .getMessage());
        }
    }

    private void validateMoneyDividedByPrice(int money) {
        if (money % Bounds.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_INVALID_PURCHASE_MONEY
                    .getMessage());
        }
    }
}
