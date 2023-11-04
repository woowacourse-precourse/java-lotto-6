package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.consts.ErrorMessage;

public class InputView {

    public static int nextInt() {
        return parseInt(Console.readLine());
    }

    public static int[] nextIntArray() {
        String[] inputs = Console.readLine().split(",");
        int[] StringToInteger = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            StringToInteger[i] = parseInt(inputs[i]);
        }
        return StringToInteger;
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.printError(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }


}
