package lotto.controller;

import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.PurchaseAmount;
import lotto.service.DrawingLottoService;
import lotto.service.IssuingLottoService;

public class LottoController {
    private final IssuingLottoService issuingLottoService;
    private final DrawingLottoService drawingLottoService;

    public LottoController() {
        issuingLottoService = new IssuingLottoService();
        drawingLottoService = new DrawingLottoService();

    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();

        LottoTickets lottoTickets = issueLotto(purchaseAmount);

        ConsoleOutput.printLottoTickets(issuingLottoService.getLottoTicketsDto(lottoTickets));
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

    private Lotto readWinningNumber() {
        while (true) {
            try {
                return drawingLottoService.createWinningNumber(ConsoleInput.readWinningNumber());
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printExceptionMessage(e.getMessage());
            } finally {
                ConsoleOutput.printNewLine();
            }
        }
    }
}
