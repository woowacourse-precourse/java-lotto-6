package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public String getPurchaseAmount() {
        return readLine();
    }

    public String getLottoResult() {
        return readLine();
    }

    public String getBonusNumber() {
        return readLine();
    }

    private String readLine() {
        return Console.readLine();
    }
}
