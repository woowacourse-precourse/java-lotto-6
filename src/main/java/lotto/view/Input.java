package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String GET_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private Input() {
    }

    public static String getPurchaseAmount() {
        return readLineWithPrompt(GET_PURCHASE_AMOUNT_MESSAGE);
    }

    private static String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
