package lotto.controller;

import lotto.model.Money;
import lotto.view.InputView;

public class LottoManager {

    public Money receiveMoney(){
        return new Money(InputView.readLine());
    }
}
