package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Utils;
import lotto.validator.MoneyValidator;

public class InputView {
    public static long getMoney() {
        String money;
        do {
            money = printMoneyInputMessage();
        } while (validateMoneyInput(money));
        return Utils.convertStringToLong(money);
    }

    private static String printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private static boolean validateMoneyInput(String money) {
        if (MoneyValidator.isNumber(money)
                || MoneyValidator.isValid(money)) {
            return true;
        }
        return false;
    }
}
