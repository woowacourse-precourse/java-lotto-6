package lotto.view;

import static lotto.utils.InputException.NOT_DIGIT_FORM;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {
    public int readPurchaseAmount() {
        try {
            String amount = readLineWithoutGap();
            return convertToInt(amount);
        } catch (NumberFormatException e) {
            NOT_DIGIT_FORM.throwException();
            return readPurchaseAmount();
        }
    }

    private String readLineWithoutGap() {
        return Console.readLine().trim();
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}
