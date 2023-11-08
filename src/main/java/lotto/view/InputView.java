package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INVALID_INPUT_ERROR = "[ERROR] 입력을 다시 확인해주세요.";

    public static String readLine() {
        return Console.readLine();
    }

    public static Integer readInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
}