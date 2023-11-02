package lotto.controller;

import java.util.List;
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

    public static List<Integer> inputWinNums() {
        String winNumber = InputView.inputWinNums();
        try {
            return WinNumberValid.validWinNumber(winNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinNums();
        }
    }

    public static int inputBonusNum() {
        String bonusNum = InputView.inputBonusNum();
        try {
            return BonusNumberValid.validBonusNumber(bonusNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNum();
        }
    }
}
