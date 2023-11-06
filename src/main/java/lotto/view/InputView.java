package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputAmount() {
        System.out.println(AMOUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
}
