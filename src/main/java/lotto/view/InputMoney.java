package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputMoney {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String TYPE_ERROR = "숫자만 입력 가능합니다.";
    private static final String MONEY_UNIT_ERROR = "숫자만 입력 가능합니다.";

    public static int input() {
        System.out.println(INPUT_MONEY);
        int money = toInt(Console.readLine());
        return moneyUnit(money);
    }

    private static int toInt(String input) {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    private static int moneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR);
        }
        return money;
    }
}
