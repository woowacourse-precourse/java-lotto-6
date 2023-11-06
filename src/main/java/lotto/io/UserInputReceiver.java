package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class UserInputReceiver {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String receivePurchaseAmount() {
        return getUserInput(PURCHASE_AMOUNT_MESSAGE);
    }

    public static String receiveWinningNumber() {
        return getUserInput(WINNING_NUMBER_MESSAGE);
    }

    public static String receiveBonusNumber() {
        return getUserInput(BONUS_NUMBER_MESSAGE);
    }

    private static String getUserInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

}
