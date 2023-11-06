package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GET_MONEY_DESCRIPTION = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBER_DESCRIPTION = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_DESCRIPTION = "보너스 번호를 입력해 주세요.";

    public String getMoney() {
        System.out.println(GET_MONEY_DESCRIPTION);
        return Console.readLine();
    }

    public String getWinningNumber() {
        System.out.println();
        System.out.println(GET_WINNING_NUMBER_DESCRIPTION);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println();
        System.out.println(GET_BONUS_NUMBER_DESCRIPTION);
        return Console.readLine();
    }
}
