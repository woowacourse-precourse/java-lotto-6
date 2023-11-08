package lotto.controller;

import lotto.model.Result;
import lotto.service.OutputService;
import lotto.view.OutputView;

public class ReturnResultController {
    private final OutputService outputService = new OutputService();
    private final OutputView outputView = new OutputView();
    private final Result result;

    public ReturnResultController(Result result) {
        this.result = result;
    }

    public void printStatistics() {
        outputView.statisticsOutput(outputService.winResult(result.getMatchResult()));
        outputView.earningRateOutput(outputService.earningRateFormat(result.getEarningRate()));
    }
}
