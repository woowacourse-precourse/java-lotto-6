package lotto.domain;

import lotto.vo.MoneyNumber;

public class Money {
    private final MoneyNumber moneyNumber;

    public Money(String money){
        this.moneyNumber = new MoneyNumber(money);
    }

    public int getTryNumber(){
        return Integer.parseInt(moneyNumber.value()) / 1000;
    }

    public int getMoney(){
        return Integer.parseInt(moneyNumber.value());
    }


}
