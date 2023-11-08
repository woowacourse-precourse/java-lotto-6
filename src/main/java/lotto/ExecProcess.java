package lotto;

import View.InputView;
import View.OutputView;

public class ExecProcess {
    private final InputView INPUT_VIEW = InputView.getInstance();
    private final OutputView OUTPUT_VIEW = new OutputView();

    public void ViewProcess() {
        INPUT_VIEW.inputPrice();
        OUTPUT_VIEW.printMyLotto();
    }
}
