package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView;
    public InputView() {
        outputView = new OutputView();
    }

    public int inputMoney() {
        outputView.enterYourAmount();
        return Integer.parseInt(Console.readLine());
    }
}
