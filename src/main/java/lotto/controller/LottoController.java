package lotto.controller;

import lotto.view.InputView;
import lotto.model.Logics;

public class LottoController {
    private int money = 0;
    private int bonus = 0;
    private int sameThree = 0;
    private int sameFour = 0;
    private int sameFive = 0;
    private int sameBonus = 0;
    private int sameAll = 0;
    private int result = 0;
    public void gamePlay () {
        inputMoney();


    }

    private void inputMoney () {
        String strMoney = InputView.printInputMoney();
        this.money = Logics.strToInt(strMoney);
    }

    private void inputBonus () {
        String strBonus = InputView.printInputBonus();
        this.bonus = Logics.strToInt(strBonus);
    }

}
