package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Money;

import static lotto.model.Money.MONEY_UNIT;

public class MoneyController {
    Money money = getMoney();
    public Money getMoney(){
        String input = Console.readLine();
        int money = Integer.parseInt(input);
        return new Money(money);
    }
    public int getPlayCount(){
        int count = money.getInputMoney();
        return count / MONEY_UNIT;
    }

}
