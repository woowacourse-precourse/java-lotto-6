package lotto.model;

public class Validator {
    private final String errorMessageMoney = "[ERROR] 금액은 1000원 단위이며, 1장부터 구매할 수 있습니다.";

    public int validateMoney(String string) {
        int money = validateMoneyisNumber(string);
        validateMoneyCorrectAmount(money);

        return money;
    }

    private int validateMoneyisNumber(String string) {
        int money;
        try {
            money = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessageMoney);
        }

        return money;
    }

    private void validateMoneyCorrectAmount(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(errorMessageMoney);
        }
    }

}
