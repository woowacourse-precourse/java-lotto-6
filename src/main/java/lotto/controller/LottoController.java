package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.io.InputManager;
import lotto.io.OutputView;
import lotto.service.LottoService;

public class LottoController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final LottoService lottoService;

    public LottoController(final OutputView outputView, final InputManager inputManager,
                           final LottoService lottoService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.lottoService = lottoService;
    }

    public void run() {
        outputView.printPurchaseAmountRequset();
        final Amount amount = inputManager.readPurchaseAmount();
        final Ticket ticket = lottoService.calculateTicketFromAmonut(amount);
        outputView.printNumberOfTicket(ticket);
        final Lottos lottos = lottoService.saveLottos(ticket);
        outputView.printNumberOfLottos(lottos);
        outputView.printWinningLottoRequset();
        WinningLotto winningLotto;
        while (true) {
            try {
                winningLotto = inputManager.readWinningLotto();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
        BonusNumber bonusNumber;
        while (true) {
            try {
                bonusNumber = inputManager.readBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
        winningLotto.updateBonusNumber(bonusNumber.toValue());
    }

}
