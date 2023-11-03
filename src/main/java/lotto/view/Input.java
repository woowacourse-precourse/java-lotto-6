package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_MONEY_GUIDE = "구입금액을 입력해 주세요.";

    private Input() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_GUIDE);
        String money = Console.readLine();
        validateMoneyBlank(money);
        validateMoneyNumeric(money);
        return Integer.parseInt(money);
    }

    private static void validateMoneyBlank(String money) {
        if (money.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateMoneyNumeric(String money) {
        if (!money.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
