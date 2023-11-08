package lotto.domain;

import lotto.view.Input;

public class Money {
    int totalMoney;
    public Money(int money) {
        this.totalMoney = money;
    }

    public void Inputmoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String notCheckedMoney = Input.consoleLine();

    }




}
