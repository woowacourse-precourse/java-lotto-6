package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String REQUEST_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";

    public static String requestBudget() {
        System.out.println(REQUEST_BUDGET_MESSAGE);
        return Console.readLine();
    }
}
