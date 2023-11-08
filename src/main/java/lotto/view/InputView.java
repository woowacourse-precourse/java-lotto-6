package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MSG_PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String MSG_WINNING_NUMBER_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String MSG_BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

    public static void printPurchaseAmountRequest() {
        System.out.println(MSG_PURCHASE_AMOUNT_REQUEST);
    }

    public static void printWinningNumberRequest() {
        System.out.println(MSG_WINNING_NUMBER_REQUEST);
    }

    public static void printBonusNumberRequest() {
        System.out.println(MSG_BONUS_NUMBER_REQUEST);
    }

    public static String getUserInput() {
        return Console.readLine();
    }
}
