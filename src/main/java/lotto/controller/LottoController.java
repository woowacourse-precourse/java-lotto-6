package lotto.controller;

import lotto.domain.calculator.CalculatorMatching;
import lotto.domain.calculator.CalculatorProfit;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private CalculatorMatching calculatorMatching;
    private CalculatorProfit calculatorProfit;
    private LottoGenerator lottoGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculatorMatching = new CalculatorMatching();
        this.calculatorProfit = new CalculatorProfit();
        this.lottoGenerator = new LottoGenerator();
    }

    private long inputPurchaseAmount() {
        long purchaseAmount;
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                purchaseAmount = inputView.getPurchaseAmount();
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorCode(e.getMessage());
            }
        }
    }
}
