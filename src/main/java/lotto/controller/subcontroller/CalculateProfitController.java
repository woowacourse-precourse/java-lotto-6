package lotto.controller.subcontroller;

import lotto.domain.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class CalculateProfitController implements Controllable {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculateProfitController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        double totalProfitRate = new ProfitCalculator().calculateProfit();
        outputView.outputProfitRate(totalProfitRate);
    }
}
