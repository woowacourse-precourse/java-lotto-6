package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.validate.BuyMoneyValidate;
import lotto.validate.WinNumberValidate;

public class InputView {

    public static String getBuyMoney() {
        String buyMoney = Console.readLine();
        BuyMoneyValidate.validateBuyMoney(buyMoney);
        return buyMoney;
    }

    public static int[] getWinNumber() {
        String winNumber = Console.readLine();
        return WinNumberValidate.validateWinNumber(winNumber);
    }

    public static String getBonusNumber() {
        return Console.readLine();
    }

}
