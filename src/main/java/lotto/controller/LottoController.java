package lotto.controller;

import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.model.LottoTickets;
import lotto.model.PurchaseAmount;
import lotto.service.IssuingLottoService;

public class LottoController {
    private final IssuingLottoService issuingLottoService;

    public LottoController() {
        issuingLottoService = new IssuingLottoService();
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();

        LottoTickets lottoTickets = issueLotto(purchaseAmount);

    }

    private LottoTickets issueLotto(PurchaseAmount purchaseAmount) {
        return issuingLottoService.issueAutoLotto(purchaseAmount);
    }

    private PurchaseAmount readPurchaseAmount() {
        while (true) {
            try {
                return issuingLottoService.createPurchaseAmount(ConsoleInput.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printExceptionMessage(e.getMessage());
            } finally {
                ConsoleOutput.printNewLine();
            }
        }

    }
}
