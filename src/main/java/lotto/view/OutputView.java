package lotto.view;

import lotto.controller.OutputController;
import lotto.model.Model;

public class OutputView {
    private final OutputController outputController;

    public OutputView(Model model) {
        this.outputController = new OutputController(model);
    }

    public void start() {
        System.out.println("당첨 통계");
        System.out.println("---");
        outputController.checkWinningLotto();
        outputController.printWinningLotto();
    }
}
