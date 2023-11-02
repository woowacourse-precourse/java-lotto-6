package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.IllegalArgumentExceptionType;

public class InputView {

    private long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.PARSE_INT_FAIL.getException();
        }
    }

    public long readMoneyAmount() {
        return parseLong(Console.readLine());
    }
}
