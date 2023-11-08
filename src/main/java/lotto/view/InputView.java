package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ENTER_CASH_IN_HAND = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String readCash() {
        System.out.println(ENTER_CASH_IN_HAND);
        return Console.readLine();
    }

    public String readWinningNumber() {
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBER);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println();
        System.out.println(ENTER_BONUS_NUMBER);
        return Console.readLine();
    }

}
