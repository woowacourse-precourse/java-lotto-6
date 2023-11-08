package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputBuyLottoView;

public class LottoController {


    private Money getLottoMoney(){
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.insertCoin();
        return new Money(money);
    }
}
