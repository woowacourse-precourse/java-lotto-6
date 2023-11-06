package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.validate.BuyMoneyValidate;
import lotto.validate.WinNumberValidate;

public class InputView {

    public static int getBuyMoney() {
        String buyMoney = Console.readLine();
        return BuyMoneyValidate.validateBuyMoney(buyMoney);
    }

    public static int[] getWinNumber() {
        String winNumber = Console.readLine();
        return WinNumberValidate.validateWinNumber(winNumber);
    }

    public static int getBonusNumber() {
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

}
