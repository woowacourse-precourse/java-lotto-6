package lotto.dto;


import static lotto.validator.InputPurchaseAmountValidator.validatePurchaseAmount;

public class InputMoney {
    private final String money;

    public InputMoney(String money) {
        validatePurchaseAmount(money);
        this.money = money;
    }

    public int getMoney() {
        return Integer.parseInt(money);
    }
}
