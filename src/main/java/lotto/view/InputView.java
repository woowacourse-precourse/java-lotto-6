package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_SPENT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String receiveSpentAmount() {
        System.out.println(ENTER_SPENT_AMOUNT);
        return Console.readLine();
    }

    public static String receiveWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String receiveBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        return Console.readLine();
    }
}
