package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public String inputPurchaseAmount() {
        return deleteBlank(Console.readLine());
    }

    public String inputWinningNumbers() {
        return deleteBlank(Console.readLine());
    }

    public String inputBonusNumbers() {
        return deleteBlank(Console.readLine());
    }

    private String deleteBlank(String input) {
        return input.replaceAll(BLANK, EMPTY);
    }
}