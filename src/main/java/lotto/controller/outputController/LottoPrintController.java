package lotto.controller.outputController;



import lotto.view.outputView.LottoPrintOutput;

import java.util.List;


public class LottoPrintController {
    private final LottoPrintOutput printOutput;

    public LottoPrintController() {
        this.printOutput = new LottoPrintOutput();
    }

    public void handleLottoDisplay(List<List<Integer>> tickets) {
        printOutput.printTickets(tickets);
    }
}