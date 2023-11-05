package lotto.utils.validation;

public class Validator {
    public int validateMoney(String string) {
        int money = validateisNumber(string);
        validateMoneyCorrectAmount(money);

        return money;
    }


    protected int validateisNumber(String string) {
        int money;
        try {
            money = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return money;
    }

    private void validateMoneyCorrectAmount(int money) {
        if (isCorrectAmount(money)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isCorrectAmount(int money) {
        return money <= 0 || money % 1000 != 0;
    }

}
