package lotto.view;

import static java.lang.Integer.parseInt;
import static lotto.utils.Console.readLine;

public class InputView {

    public static int readNumber() {
        try {
            return parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String readWinningNumbers() {
        return readLine();
    }
}
