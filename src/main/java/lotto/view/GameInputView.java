package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class GameInputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해주세요.";

    public String getPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        String input = getInput();

        return input;
    }

    public String getWinningNumbersInput() {
        System.out.println(WINNING_NUMBER_INPUT);
        String input = getInput();

        return input;
    }

    public String getBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT);
        String input = getInput();

        return input;
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    private String getInput() {
        return Console.readLine();
    }
}
