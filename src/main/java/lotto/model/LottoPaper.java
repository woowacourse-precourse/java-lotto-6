package lotto.model;

import static lotto.view.ExceptionMessages.IS_NOT_DIVISIBLE;
import static lotto.view.ExceptionMessages.IS_NOT_NUMBER;

public class LottoPaper {

    private int amount;

    public int buy(String totalAmount) {
        validate(totalAmount);
        this.amount = calculatorLottoPaperNumber(totalAmount);
        return amount;
    }

    public int getLottoPaper() {
        return amount;
    }

    private void validate(String totalAmount) {
        isInputValueNumber(totalAmount);
        isDivisibleByThousand(totalAmount);
    }

    private void isInputValueNumber(String totalAmount) {
        if (!totalAmount.matches("\\d+")) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.getMessage());
        }
    }

    private void isDivisibleByThousand(String totalAmount) {
        int money = stringToIntegerMoney(totalAmount);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE.getMessage());
        }
    }

    private int calculatorLottoPaperNumber(String totalAmount) {
        return stringToIntegerMoney(totalAmount) / 1000;
    }

    private int stringToIntegerMoney(String totalAmount) {
        return Integer.parseInt(totalAmount);
    }
}
