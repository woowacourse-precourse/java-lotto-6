package lotto.controller;

import lotto.domain.*;
import lotto.view.InputMoneySpentOnLottoView;
import lotto.view.InputWinningNumbersView;
import lotto.view.InputBonusNumberView;

import static lotto.view.OutputNumberOfBoughtLottoView.printBoughtLottos;
//import static lotto.view.OutputLottoNumbersView..printBoughtLottos;
//import static lotto.view.OutputLottoResultsView..printBoughtLottos;

public class LottoController {

    public void start(){
        User lotto = getMoney();
        printBoughtLottos(lotto);
    }

    public User getMoney(){
        InputMoneySpentOnLottoView spentMoney = new InputMoneySpentOnLottoView();
        int money = spentMoney.getValue();

        return new User(money);
    }
}
