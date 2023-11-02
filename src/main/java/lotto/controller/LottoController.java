package lotto.controller;

import lotto.view.InputView;
import lotto.model.Logics;
import lotto.model.Errors;

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
        boolean isValidate = false;
        while(!isValidate) {
            try {
                String strMoney = InputView.printInputMoney();
                this.money = Errors.isInteger(strMoney);
                Errors.isMinMoney(this.money);
                Errors.isWrongMoney(this.money);
                isValidate = true;
            } catch (IllegalArgumentException e) {
                isValidate = false;
            }
        }
    }

    private void inputBonus () {
        boolean isValidate = false;
        while(!isValidate) {
            try {
                String strBonus = InputView.printInputBonus();
                this.bonus = Errors.isInteger(strBonus);
                Errors.isWrongRange(this.bonus);
                isValidate = true;
            } catch (IllegalArgumentException e) {
                isValidate = false;
            }
        }
    }

}
