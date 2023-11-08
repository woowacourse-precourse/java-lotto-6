package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoNumberInput {

    private static final String REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String requestWinningNumberInput() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String requestBonusNumberInput() {
        System.out.println();
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
