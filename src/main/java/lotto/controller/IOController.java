package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class IOController {
    private final InputView inputView;
    private final OutputView outputView;

    public IOController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int purchaseAmountInput() {
        return inputView.purchaseAmountInput();
    }
    public List<Integer> winningNumberInput() {
        return inputView.winningNumberInput();
    }

    public int bonusNumberInput() {
        return inputView.bonusNumberInput();
    }

    public void lottoCountCheck(int count) {
        outputView.confirmLottoCount(count);
    }

    public void showLotto(String output) {
        outputView.showLotto(output);
    }

    public void showStatisticsMessage() {
        outputView.showStatisticMessage();
    }

    public void showResult(String result) {
        outputView.showResult(result);
    }
    public void showRevenue(double revenue) {
        outputView.showRevenue(revenue);
    }
}
