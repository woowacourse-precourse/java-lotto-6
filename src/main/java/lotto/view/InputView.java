package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String ENTER_BUDGET_TEXT = "구입금액을 입력해 주세요.";
    public static final String ENTER_WINNING_NUMBERS_TEXT = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER_TEXT = "보너스 번호를 입력해 주세요.";

    public String scanRawInput() {
        return Console.readLine();
    }

    public String scanBudget() {
        renderEnterBudgetText();
        return scanRawInput();
    }

    public String scanWinningNumbers() {
        renderEnterWinningNumbersText();
        return scanRawInput();
    }

    public String scanBonusNumber() {
        renderEnterBonusNumberText();
        return scanRawInput();
    }

    public void renderEnterBudgetText() {
        System.out.println(ENTER_BUDGET_TEXT);
    }

    public void renderEnterWinningNumbersText() {
        System.out.println(ENTER_WINNING_NUMBERS_TEXT);
    }

    public void renderEnterBonusNumberText() {
        System.out.println(ENTER_BONUS_NUMBER_TEXT);
    }
}