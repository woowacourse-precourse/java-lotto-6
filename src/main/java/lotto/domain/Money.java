package lotto.domain;

import lotto.view.Input;

public class Money {

    int totalMoney;

    public Money(int money) {
        this.totalMoney = money;
    }

    public void checkMoney () {
        if(this.totalMoney % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

}
