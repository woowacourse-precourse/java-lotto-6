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
            Integer parsed = StringParser.parsePurchaseAmount(str);
            LottoValidator.validatePurchaseAmount(parsed);
            this.purchaseAmount = parsed;
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
        try {
            ConsolePrinter.printWinningNumberMessage();

            String str = ConsoleScanner.scanWinningNumber();
            WinningNumber parsed = StringParser.parseWinningNumber(str);
            LottoValidator.validateWinningNumber(parsed);
            this.winningNumber = parsed;
        } catch (Exception e) {
            ConsolePrinter.printErrorMessage(e.getMessage());

            initiateWinningNumber();
        }
    }

    private void initiateBonus() {
        try {
            ConsolePrinter.printBonusNumberMessage();

            String str = ConsoleScanner.scanBonusNumber();
            Integer parsed = StringParser.parseBonusNumber(str);
            LottoValidator.validateBonusNumber(parsed, winningNumber);
            this.bonus = parsed;
        } catch (Exception e) {
            ConsolePrinter.printErrorMessage(e.getMessage());

            initiateBonus();
        }
    }
}
