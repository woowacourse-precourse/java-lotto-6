package lotto.view;

import lotto.controller.OutputController;
import lotto.model.db.Model;

import static lotto.util.Constant.OutputClass.PRINT_MESSAGE_WINNING_STATISTICS;
import static lotto.util.Constant.OutputClass.PRINT_MESSAGE_WINNING_STATISTICS_LINE;

public class OutputView {
    private final OutputController outputController;

    public OutputView(Model model) {
        this.outputController = new OutputController(model);
    }

    public void start() {
        System.out.println();
        System.out.println(PRINT_MESSAGE_WINNING_STATISTICS);
        System.out.println(PRINT_MESSAGE_WINNING_STATISTICS_LINE);
        outputController.checkWinningLotto();
        outputController.printWinningLotto();
        outputController.printRateOfReturn();
    }
}
