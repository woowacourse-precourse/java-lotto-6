package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String ASK_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String ERROR_NEED_NUMBER = "[ERROR] 숫자를 입력해 주세요.";

    public int askPurchaseMoney() {
        println(ASK_PURCHASE_MONEY);
        return toInteger(Console.readLine());
    }

    private int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NEED_NUMBER);
        }
    }

    private void println(String message) {
        System.out.println(message);
    }
}
