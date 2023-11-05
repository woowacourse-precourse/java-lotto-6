package lotto.controller;

import lotto.domain.InputNumber;
import lotto.domain.Money;
import lotto.view.OutputView;
import lotto.view.Request;

public class Lottogame {
    public void start(){
        Integer lottomoney = InputNumber.InputMoney(Request.requestNubmer());
        Integer count = Money.countMoney(lottomoney);

    }
}
