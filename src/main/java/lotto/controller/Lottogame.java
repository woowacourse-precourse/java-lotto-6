package lotto.controller;


import static lotto.view.OutputView.PURCHASE_RESULT;

import java.util.List;
import lotto.domain.Generate;
import lotto.domain.InputNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.OutputView;
import lotto.view.OutputView.*;
import lotto.view.Request;

public class Lottogame {
    public void start(){
        Integer lottomoney = InputNumber.InputMoney(Request.requestNubmer());
        Integer count = Money.countMoney(lottomoney);
    }
}
