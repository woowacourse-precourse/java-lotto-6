package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Exception.ONLY_NUMERIC_INPUT_FOR_MONEY;

public class InputView {
    public int inputMoney() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_FOR_MONEY.getMessage());
        }
    }
}
