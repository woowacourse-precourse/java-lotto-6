package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.MessageConstant;

public class InputView {

    public static String getInputLine() {
        return removeSpace(Console.readLine());
    }

    private static String removeSpace(String input) {
        return input.replaceAll(MessageConstant.SPACE_REGEX, MessageConstant.SPACE_REPLACEMENT);
    }
}
