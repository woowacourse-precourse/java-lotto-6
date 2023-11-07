package lotto.domain.dto;


import lotto.validatior.InputPurchaseAmountValidator;

public class InputMoney {
    private final String money;

    public InputMoney(String money) {
        InputPurchaseAmountValidator.validatePurchaseAmount(money);
        this.money = money;
    }

    public int getMoney() {
        return Integer.parseInt(money);
    }
}
