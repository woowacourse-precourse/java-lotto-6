package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputAmount() {
        System.out.println(AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
