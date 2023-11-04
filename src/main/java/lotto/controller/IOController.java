package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class IOController {
    private final InputView inputView;
    private final OutputView outputView;

    public IOController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int purchaseAmountInput() {
        int amount = inputView.purchaseAmountInput();
        //validation
        return amount;
    }
    public List<Integer> winningNumberInput() {
        List<Integer> numberInput = inputView.winningNumberInput();
        //validation
        return numberInput;
    }

    public int bounusNumberInput() {
        int bounusNumber = inputView.bonusNumberInput();
        //validation
        return bounusNumber;
    }

    public void lottoCountCheck(int count) {
        outputView.confirmLottoCount(count);
    }

    public void showLotto(List<Integer> output) {
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
