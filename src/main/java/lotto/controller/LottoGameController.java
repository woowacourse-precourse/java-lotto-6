package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.lottoResult.LottoResultBoard;
import lotto.domain.lottoTicket.BonusNumber;
import lotto.domain.lottoTicket.Lotto;
import lotto.domain.lottoTicket.LottoTickets;
import lotto.domain.lottoTicket.WinningLotto;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        LottoTickets autoLottoTickets = generateAutoLottoTickets(purchaseAmount);

        outputView.printAutoLottoTickets(autoLottoTickets);

        Lotto winningNumbers = inputWinningNumbers();
        WinningLotto winningLotto = generateWinningLotto(winningNumbers);
        LottoResultBoard lottoResultBoard = lottoGameService.generateLottoResultStatistics(
                autoLottoTickets,
                winningLotto
        );

        outputView.printLottoResultStatistics(lottoResultBoard, purchaseAmount);
    }

    private WinningLotto generateWinningLotto(Lotto winningNumbers) {
        try {
            BonusNumber bonusNumber = inputBonusNumber();
            return lottoGameService.generateWinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return generateWinningLotto(winningNumbers);
        }
    }

    private BonusNumber inputBonusNumber() {
        String inputValue = inputView.inputBonusNumber();
        return lottoGameService.generateBonusNumber(inputValue);
    }

    private Lotto inputWinningNumbers() {
        try {
            String inputValue = inputView.inputWinningLotto();
            return lottoGameService.generateWinningNumbers(inputValue);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputWinningNumbers();
        }
    }

    private LottoTickets generateAutoLottoTickets(PurchaseAmount purchaseAmount) {
        int lottoTicketQuantity = purchaseAmount.getPurchaseQuantity();
        return lottoGameService.generateLottoTickets(lottoTicketQuantity);
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            String inputValue = inputView.inputPurchaseAmount();
            return lottoGameService.generatePurchaseAmount(inputValue);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputPurchaseAmount();
        }
    }
}
