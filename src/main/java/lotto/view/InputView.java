package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPurchaseAmount() {
        return inputLine();
    }

    public String inputWinningNumbers() {
        return inputLine();
    }

    public String inputBonusNumber() {
        return inputLine();
    }

    private String inputLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
