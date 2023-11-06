package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.InputValidate;

public class InputView {

    public static String getBuyMoney() {
        String buyMoney = Console.readLine();
        InputValidate.validateBuyMoney(buyMoney);
        return buyMoney;
    }

    public static String getWinNumber() {
        return Console.readLine();
    }

    public static String getBonusNumber() {
        return Console.readLine();
    }

}
