package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class InputMoney {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static int input() {
        System.out.println(INPUT_MONEY);
        return toInt(Console.readLine());
    }

    private static int toInt(String input) {
        return Integer.parseInt(Console.readLine());
    }
}
