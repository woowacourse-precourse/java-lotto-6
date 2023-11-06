package lotto.controller;

import java.util.List;
import lotto.model.LottoResult;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;
import lotto.view.Output;
import lotto.view.input.AmountInput;
import lotto.view.input.Input;

public class Controller {

    private final static String PROFITS_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";
    private final static String RESULT_INSTRUCTION_MESSAGE = "당첨 통계";
    private final static String SEPARATOR_LINE = "---";

    private final PurchaseAmount purchaseAmount;
    private final LottoManager lottoManager;
    private final LottoResult lottoResult;

    public Controller() {
        purchaseAmount = new PurchaseAmount(readAmount());
        lottoManager = new LottoManager(purchaseAmount);
        lottoResult = new LottoResult();
    }

    public void start() {
        saveResults();
        printResults();
        printProfitRate();
    }

    private double calculateProfitRate() {
        return (double) lottoResult.getProfits() / purchaseAmount.purchaseAmount();
    }

    private void printProfitRate() {
        Output.printMessage(PROFITS_RATE_MESSAGE_FORMAT, calculateProfitRate());
    }

    private void printResults() {
        Output.printMessage(RESULT_INSTRUCTION_MESSAGE);
        Output.printMessage(SEPARATOR_LINE);
        Output.printMessage(lottoResult.buildResultString());
    }

    private void saveResults() {
        List<Rank> results = lottoManager.calculateResults();

        for (Rank result : results) {
            lottoResult.addOne(result);
        }
    }

    private int readAmount() {
        Input input = new AmountInput();
        return Integer.parseInt(input.readLine());
    }
}
