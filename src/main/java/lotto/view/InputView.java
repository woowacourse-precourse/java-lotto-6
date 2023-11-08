package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String inputLottoPurchaseAmount() {
        return readLine();
    }

    public String inputWinningLotto() {
        return readLine();
    }

    public String inputBonusNumber() {
        return readLine();
    }

    private String readLine() {
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
