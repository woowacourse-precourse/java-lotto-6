package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorCode;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }


    public Integer requestInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_NOT_INTEGER.getMessage());
        }
    }
}
