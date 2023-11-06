package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoResult;
import lotto.model.ProfitRate;
import lotto.model.WinningNumbers;
import lotto.model.collections.LottoBundle;
import lotto.model.collections.LottoPurchaseAmount;
import lotto.model.collections.LottoTicketCount;
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
        LottoPurchaseAmount purchaseAmount = getLottoPurchaseAmount();
        LottoTicketCount ticketCount = getLottoTicketCount(purchaseAmount);
        LottoBundle lottoBundle = getLottoBundle(ticketCount);
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        getLottoResult(purchaseAmount, lottoBundle, winningNumbers, bonusNumber);
    }

    private LottoPurchaseAmount getLottoPurchaseAmount() {
        while (true) {
            try {
                OutputView.printPurchaseAmountMessage();
                return lottoTicketService.parsePurchaseAmount(InputView.read());
            } catch (Exception e) {
                OutputView.printErrorMessage();
            }
        }
    }

    private LottoTicketCount getLottoTicketCount(LottoPurchaseAmount purchaseAmount) {
        LottoTicketCount ticketCount = lottoTicketService.calculateTicketCount(purchaseAmount);
        OutputView.printTicketCountMessage(ticketCount.getCount());
        return ticketCount;
    }

    private LottoBundle getLottoBundle(LottoTicketCount ticketCount) {
        LottoBundle lottoBundle = lottoTicketService.generateLottoBundle(ticketCount.getCount());
        OutputView.printLottoBundle(lottoBundle);
        return lottoBundle;
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                OutputView.printWinningNumbersMessage();
                return winningNumberService.createWinningNumbers(InputView.read());
            } catch (Exception e) {
                OutputView.printErrorMessage();
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                OutputView.printBonusNumberMessage();
                return winningNumberService.createBonusNumber(InputView.read(), winningNumbers.getNumbers());
            } catch (Exception e) {
                OutputView.printErrorMessage();
            }
        }
    }

    private void getLottoResult(LottoPurchaseAmount purchaseAmount, LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        OutputView.printResultMessage();
        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        ProfitRate profitRate = lottoResultService.calculateProfitRate(lottoResult, purchaseAmount);
        OutputView.printLottoResult(lottoResult, profitRate);
    }
}
