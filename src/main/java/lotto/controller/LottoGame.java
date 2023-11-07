package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.ui.ConsolePrinter;
import lotto.ui.ConsoleScanner;
import lotto.util.LottoValidator;
import lotto.util.StringParser;

public class LottoGame {
    private Integer purchaseAmount;
    private Lottos lottos;
    private WinningNumber winningNumber;
    private Integer bonus;

    public LottoGame() {
    }

    public void run() {
        initiate();
    }

    public void initiate() {
        initiatePurchaseAmount();
        initiateLottos();
        initiateWinningNumber();
        initiateBonus();
    }

    private void initiatePurchaseAmount() {
        try {
            ConsolePrinter.printPurchaseAmountMessage();

            String str = ConsoleScanner.scanPurchaseAmount();
            Integer purchasedAmount = StringParser.parsePurchaseAmount(str);
            LottoValidator.validatePurchaseAmount(purchasedAmount);
            this.purchaseAmount = purchasedAmount;
        } catch (Exception e) {
            ConsolePrinter.printErrorMessage(e.getMessage());

            initiatePurchaseAmount();
        }
    }

    private void initiateLottos() {

    }

    private void initiateWinningNumber() {

    }

    private void initiateBonus() {

    }
}
