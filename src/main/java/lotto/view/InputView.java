package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String ENTER_BUDGET_TEXT = "구입금액을 입력해 주세요.";
    public static final String ENTER_WINNING_NUMBERS_TEXT = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER_TEXT = "보너스 번호를 입력해 주세요.";

    public String scanBudget() {
        System.out.println(ENTER_BUDGET_TEXT);
        return scanRawInput();
    }

    public String scanWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS_TEXT);
        return scanRawInput();
    }

    public String scanBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER_TEXT);
        return scanRawInput();
    }

    public String scanRawInput() {
        return Console.readLine();
    }
}