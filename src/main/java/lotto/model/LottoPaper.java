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
        if (!isInputValueNumber(totalAmount)) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.getMessage());
        }

        if (!isDivisibleByThousand(totalAmount)) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE.getMessage());
        }
    }

    private boolean isInputValueNumber(String totalAmount) {
        return true;
    }

    private boolean isDivisibleByThousand(String totalAmount) {
        int money = stringToIntegerMoney(totalAmount);
        return money % 1000 == 0;
    }

    private int calculatorLottoPaperNumber(String totalAmount) {
        return stringToIntegerMoney(totalAmount) / 1000;
    }

    private int stringToIntegerMoney(String totalAmount) {
        return Integer.parseInt(totalAmount);
    }
}
