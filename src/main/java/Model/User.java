package Model;

public class User {

    private static final int MIN_MONEY_RANGE = 1000;
    private static final int MAX_MONEY_RANGE = 1000000000;
    private static final int MONEY_MAX_LENGTH = 10;

    private int money;

    User (String money){
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
            throw new IllegalArgumentException();
        }
    }

    void validateMoneyLength(String money) {
        if (money.length() > MONEY_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    void validateMoneyInRange(int money) {
        if (money >= MIN_MONEY_RANGE && money <= MAX_MONEY_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    void validateMoneyNumeric(String money) {
        for (int moneyIndex = 0; moneyIndex < money.length(); moneyIndex++) {
            if (Character.isDigit(money.charAt(moneyIndex))) {
                throw new IllegalArgumentException();
            }
        }
    }

    void validateMoneyDividedTByThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
