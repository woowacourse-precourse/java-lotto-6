package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public String getPurchaseAmountInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = getInput();

        return input;
    }

    public String getWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = getInput();

        return input;
    }

    private String getInput() {
        return Console.readLine();
    }
}
