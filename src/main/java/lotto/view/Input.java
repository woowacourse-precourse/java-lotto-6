package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String GET_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private Input() {
    }

    public static String getPurchaseAmount() {
        return readLineWithPrompt(GET_PURCHASE_AMOUNT_MESSAGE);
    }

    public static String getWinningNumbers() {
        return readLineWithPrompt(GET_WINNING_NUMBERS_MESSAGE);
    }

    public static String getBonusNumber() {
        return readLineWithPrompt(GET_BONUS_NUMBER_MESSAGE);
    }

    private static String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
