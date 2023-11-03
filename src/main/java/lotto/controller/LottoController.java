package lotto.controller;

import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.model.PurchaseAmount;
import lotto.service.IssuingLottoService;

public class LottoController {
    private final IssuingLottoService issuingLottoService;

    public LottoController() {
        issuingLottoService = new IssuingLottoService();
    }

    public void run() {

    }

    private PurchaseAmount createPurchaseAmount() {
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
