package lotto.controller;

import lotto.valid.BonusNumberValid;
import lotto.valid.MoneyValid;
import lotto.valid.WinNumberValid;
import lotto.view.InputView;

public class InputController {

    public static int inputBuyingMoney() {
        String input = InputView.inputBuyingMoney();
        try {
            return MoneyValid.validMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBuyingMoney();
        }
    }

    public static String inputWinNums() {
        String winNumber = InputView.inputWinNums();
        try {
            WinNumberValid.validWinNumber(winNumber);
            return winNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinNums();
        }
    }

    public static String inputBonusNum() {
        String bonusNum = InputView.inputBonusNum();
        try {
            BonusNumberValid.validBonusNumber(bonusNum);
            return bonusNum;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNum();
        }
    }
}
