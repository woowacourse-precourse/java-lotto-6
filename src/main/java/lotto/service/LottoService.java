package lotto.service;

import lotto.model.*;
import lotto.service.lotto.LottoResultService;
import lotto.service.lotto.LottoTicketService;
import lotto.service.lotto.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private final LottoTicketService lottoTicketService = new LottoTicketService();
    private final WinningNumberService winningNumberService = new WinningNumberService();
    private final LottoResultService lottoResultService = new LottoResultService();

    public LottoService() {
    }

    public LottoPurchaseAmount getValidPurchaseAmount() {
        while (true) {
            try {
                OutputView.printPurchaseAmountMessage();
                return lottoTicketService.parsePurchaseAmount(InputView.read());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public WinningNumbers getValidWinningNumbers() {
        while (true) {
            try {
                OutputView.printWinningNumbersMessage();
                return winningNumberService.createWinningNumbers(InputView.read());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public BonusNumber getValidBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                OutputView.printBonusNumberMessage();
                return winningNumberService.createBonusNumber(InputView.read(), winningNumbers.getNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public LottoTicketCount getTicketCount(LottoPurchaseAmount purchaseAmount) {
        LottoTicketCount ticketCount = lottoTicketService.calculateTicketCount(purchaseAmount);
        OutputView.printTicketCountMessage(ticketCount.getCount());
        return ticketCount;
    }

    public LottoBundle getLottoBundle(LottoTicketCount ticketCount) {
        LottoBundle lottoBundle = lottoTicketService.generateLottoBundle(ticketCount.getCount());
        OutputView.printLottoBundle(lottoBundle);
        return lottoBundle;
    }

    public LottoResult getLottoResult(LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        OutputView.printResultMessage();
        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        OutputView.printLottoResult(lottoResult);
        return lottoResult;
    }

    public void showProfitRate(LottoResult lottoResult, LottoPurchaseAmount purchaseAmount) {
        ProfitRate profitRate = lottoResultService.calculateProfitRate(lottoResult, purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }
}
