package lotto.controller;

import lotto.controller.subcontroller.CalculateProfitController;
import lotto.controller.subcontroller.CompareResultController;
import lotto.controller.subcontroller.IssueLottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private IssueLottoController issueLottoController;
    private CompareResultController compareResultController;
    private CalculateProfitController calculateProfitController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeControllers();
    }

    private void initializeControllers() {
        issueLottoController = new IssueLottoController(inputView, outputView);
        compareResultController = new CompareResultController(inputView, outputView);
        calculateProfitController = new CalculateProfitController(inputView, outputView);
    }

    public void start() {
        issueLottoController.process();
        compareResultController.process();
        calculateProfitController.process();
    }


}
