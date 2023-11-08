package model;

import exception.Exception;
public class Money {

    private static final int MIN_MONEY_RANGE = 1000;
    private static final int MAX_MONEY_RANGE = 1000000000;
    private static final int MONEY_MAX_LENGTH = 10;
    private static final int LOTTO_PRICE = 1000;

    private int money;

    public Money(String money){
        this.money = validateMoney(money);
    }

    int validateMoney(String moneyInput) {
        validateEmptyInput(moneyInput);
        validateMoneyLength(moneyInput);
        validateMoneyNumeric(moneyInput);
        validateMoneyInRange(Integer.parseInt(moneyInput));
        validateMoneyDividedTByThousand(Integer.parseInt(moneyInput));
        return Integer.parseInt(moneyInput);
    }

    void validateEmptyInput(String userInput) {
        if (userInput.isEmpty() || userInput.isBlank()) {
            Exception.raiseInvalidInputException();
        }
    }

    void validateMoneyLength(String money) {
        if (money.length() > MONEY_MAX_LENGTH) {
            Exception.raiseInvalidMoneyRangeException();
        }
    }

    void validateMoneyInRange(int money) {
        if (money < MIN_MONEY_RANGE || money > MAX_MONEY_RANGE) {
            Exception.raiseInvalidMoneyRangeException();
        }
    }

    void validateMoneyNumeric(String money) {
        for (int moneyIndex = 0; moneyIndex < money.length(); moneyIndex++) {
            if (!Character.isDigit(money.charAt(moneyIndex))) {
                Exception.raiseInvalidMoneyArgumentException();
            }
        }
    }

    void validateMoneyDividedTByThousand(int money) {
        if (money % LOTTO_PRICE != 0) {
            Exception.raiseMoneyNotDevidedByThousandException();
        }
    }

    boolean canPurchaseLotto() {
        return money >= LOTTO_PRICE;
    }

    void purchaseLotto() {
        money -= LOTTO_PRICE;
    }
}
