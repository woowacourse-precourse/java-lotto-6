package lotto.model;

import lotto.constant.LottoConstant;

public class Money {
    private int money;
    public Money(int money) {
        validate();
        this.money = money;
    }
    private void validate(){
        if (money % LottoConstant.LOTTO_PRICE.getValue() != 0){
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
