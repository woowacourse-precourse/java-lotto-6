package lotto.domain;

import lotto.view.ExceptionMessage;

public class LottoBuy {
    private Integer money;
    private Integer quantity;
    private static int MONEY_UNIT = 1000;

    public LottoBuy(Integer money){
        validate(money);
        this.money = money;
    }

    public Integer getMoney() {
        return this.money;
    }

    public Integer getQuantity(){
        return this.quantity = money / MONEY_UNIT;
    }

    private void validate(Integer money) {
        if(money % MONEY_UNIT != 0){
            ExceptionMessage.unitException();
            throw new IllegalArgumentException();
        }
    }
}
