package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.constance.PrintConst;

public class Reader {

    public static int getMoney() {
        String inputMoney = Console.readLine();
        int money = parseInt(inputMoney);
        validateMoneyUnit(money);
        return money;
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private static void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요");
        }
    }
}
