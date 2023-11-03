package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_MONEY_GUIDE = "구입금액을 입력해 주세요.";

    private Input() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_GUIDE);
        return Integer.parseInt(Console.readLine());
    }
}
