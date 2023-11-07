package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoResult;
import lotto.model.ProfitRate;
import lotto.model.WinningNumbers;
import lotto.model.LottoBundle;
import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoTicketCount;
import lotto.service.LottoResultService;
import lotto.service.LottoTicketService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoTicketService lottoTicketService;
    private final WinningNumberService winningNumberService;
    private final LottoResultService lottoResultService;

    public LottoController(
            LottoTicketService lottoTicketService,
            WinningNumberService winningNumberService,
            LottoResultService lottoResultService) {
        this.lottoTicketService = lottoTicketService;
        this.winningNumberService = winningNumberService;
        this.lottoResultService = lottoResultService;
    }

    public void run() {
        while (true) {
            try {
                OutputView.printPurchaseAmountMessage();
                LottoPurchaseAmount purchaseAmount = lottoTicketService.parsePurchaseAmount(InputView.read());
                LottoTicketCount ticketCount = lottoTicketService.calculateTicketCount(purchaseAmount);
                OutputView.printTicketCountMessage(ticketCount.getCount());

                LottoBundle lottoBundle = lottoTicketService.generateLottoBundle(ticketCount.getCount());
                OutputView.printLottoBundle(lottoBundle);

                OutputView.printWinningNumbersMessage();
                WinningNumbers winningNumbers = winningNumberService.createWinningNumbers(InputView.read());
                OutputView.printBonusNumberMessage();
                BonusNumber bonusNumber = winningNumberService.createBonusNumber(InputView.read(), winningNumbers.getNumbers());

                OutputView.printResultMessage();
                LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
                ProfitRate profitRate = lottoResultService.calculateProfitRate(lottoResult, purchaseAmount);
                OutputView.printLottoResult(lottoResult, profitRate);

                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
