package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static String userAmountInput() {
        return input(INPUT_PURCHASE_PRICE_MESSAGE);
    }

    public static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
