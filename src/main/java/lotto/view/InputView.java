package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    public int readPurchaseAmount() {
        outputView.printRequestPurchaseAmount();
        return Integer.parseInt(Console.readLine());
    }

    public String readWinningNumbers() {
        outputView.printRequestWinningNumbers();
        return Console.readLine();
    }

    public int readBonusNumber() {
        outputView.printRequestBonusNumber();
        return Integer.parseInt(Console.readLine());
    }
}
