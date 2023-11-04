package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static int getBuyAmountFromInput() {
        String buyAmount = read();
        return Integer.parseInt(buyAmount);
    }

    private static String read() {
        return Console.readLine().trim();
    }
}
