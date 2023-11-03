package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String REQUEST_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String REQUEST_BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String REQUEST_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static String requestBudget() {
        System.out.println(REQUEST_BUDGET_MESSAGE);
        return Console.readLine();
    }

    public static String requestBonusNum() {
        System.out.println(REQUEST_BONUS_NUM_MESSAGE);
        return Console.readLine();
    }

    public static String requestWinningNum() {
        System.out.println(REQUEST_WINNING_NUM_MESSAGE);
        return Console.readLine();
    }
}
