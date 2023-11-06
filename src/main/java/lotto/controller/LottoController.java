package lotto.controller;

import lotto.controller.inputController.PurchaseController;
import lotto.controller.inputController.WinningNumberController;
import lotto.controller.outputController.LottoPrintController;
import lotto.model.lottoGenerator.Lotto;
import lotto.model.lottoGenerator.LottoTicketCreator;
import lotto.view.inputView.LottoBonusWinningNumberInput;

import java.util.List;

public class LottoController {

    private final PurchaseController purchaseController = new PurchaseController();
    private final LottoPrintController lottoPrintController = new LottoPrintController();
    private final LottoTicketCreator ticketCreator = new LottoTicketCreator();
    private final WinningNumberController winningNumberController = new WinningNumberController();
    private final LottoBonusWinningNumberInput bonusNumberInput = new LottoBonusWinningNumberInput();


    public void start() {
        int purchaseAmount = purchaseController.getPurchaseAmount();
        List<Lotto> lotto = ticketCreator.createLottoTickets(purchaseAmount);
        lottoPrintController.handleLottoDisplay(lotto);
        List<Integer> winningNumbers = winningNumberController.getWinningNumbers();
        int bonusNumber = bonusNumberInput.requestBonusNumber();
    }
}