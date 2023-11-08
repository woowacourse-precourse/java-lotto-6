package lotto.view;

import lotto.util.InputUtil;

public class InputView {
    private static final InputUtil inputUtil = new InputUtil();

    public static String getInputWithMessage(String message) {
        System.out.println(message);
        return inputUtil.getInput();
    }
}
