package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.Lotto;
import lotto.validate.BuyMoneyValidate;
import lotto.validate.WinNumberValidate;

public class InputView {

    public static int getBuyMoney() {
        while (true) {
            try {
                String buyMoney = Console.readLine();
                return BuyMoneyValidate.validateBuyMoney(buyMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto getWinNumber() {
        while (true) {
            try {
                String winNumber = Console.readLine();
                return new Lotto(WinNumberValidate.validateWinNumber(winNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(Lotto winNumbers) {
        while (true) {
            try {
                String bonusNumber = Console.readLine();
                return WinNumberValidate.validateBonusNumber(bonusNumber, winNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
