package lotto.controller;

import lotto.domain.WinNumber;
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

    public static String inputBonusNum(WinNumber winNumber) {
        String bonusNum = InputView.inputBonusNum();
        try {
            BonusNumberValid.validBonusNumber(winNumber, bonusNum);
            return bonusNum;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNum(winNumber);
        }
    }
}