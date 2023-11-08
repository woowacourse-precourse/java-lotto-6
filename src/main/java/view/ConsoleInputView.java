package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import exception.ParseException;

public class ConsoleInputView implements InputView {
    @Override
    public int enterPurchaseAmount() {
        return parseInt(readLine());
    }

    private Integer parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new ParseException();
        }
    }
}
