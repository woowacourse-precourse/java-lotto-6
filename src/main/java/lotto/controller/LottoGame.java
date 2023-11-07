package lotto.controller;

import static lotto.constant.GameOptions.PRICE;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.ui.ConsolePrinter;
import lotto.ui.ConsoleScanner;
import lotto.util.LottoValidator;
import lotto.util.StringParser;

public class LottoGame {
    private Integer purchaseAmount;
    private Lottos lottos = new Lottos();
    private WinningNumber winningNumber;
    private Integer bonus;
    private LottoGenerator lottoGenerator = new LottoGenerator();

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
        int lottoCount = purchaseAmount % PRICE.getValue();
        ConsolePrinter.printLottoPurchasedMessage(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoGenerator.generate();
            ConsolePrinter.printLottoNumbers(lotto);
            lottos.add(lotto);
        }
    }

    private void initiateWinningNumber() {

    }

    private void initiateBonus() {

    }
}
