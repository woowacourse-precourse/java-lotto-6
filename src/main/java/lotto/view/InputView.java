package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public int getPurchaseAmount() {
        String input = readLine();

        return Integer.parseInt(input);
    }

    private String readLine() {
        return Console.readLine();
    }
}
