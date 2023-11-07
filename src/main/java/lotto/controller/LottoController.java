package lotto.controller;

import lotto.domain.*;
import lotto.view.InputMoneySpentOnLottoView;
import lotto.view.InputWinningNumbersView;
import lotto.view.InputBonusNumberView;

public class LottoController {

    public void play(){
        User lotto = getMoney();
    }

    public User getMoney(){
        InputMoneySpentOnLottoView spentMoney = new InputMoneySpentOnLottoView();
        int money = spentMoney.getValue();

        return new User(money);
    }
}
