package lotto.controller;

import lotto.domain.*;
import lotto.enums.SystemErrorMessages;
import lotto.utils.RetryUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame implements Game {

    private LottoPurchase lottoPurchase;
    private LottoTickets lottoTickets;
    private WinningLotto winningLotto;
    private WinningResult winningResult;
    private TotalWinning totalWinning;

    @Override
    public void run() {
        collectPurchaseAmount();
        generateLottoTickets();
        announcePurchaseResults();

        collectWinningNumbers();
        calculateWinningResults();
        announceWinningResults();
    }

    private void collectPurchaseAmount() {
        RetryUtil.retry(() -> lottoPurchase = LottoPurchase.valueOf(InputView.lottoPurchaseAmountInput()));
    }

    private void generateLottoTickets() {
        lottoTickets = lottoPurchase.generateLottoTickets();
    }

    private void announcePurchaseResults() {
        announceNumberOfTickets();
        announceUserLottoTickets();
    }

    private void announceNumberOfTickets() {
        if (lottoPurchase == null) {
            throw new IllegalStateException(SystemErrorMessages.LOTTO_PURCHASE_WAS_NOT_CREATED.getMessage());
        }
        OutputView.printNumberOfPurchasedLottoTickets(lottoPurchase);
    }

    private void announceUserLottoTickets() {
        if (lottoTickets == null) {
            throw new IllegalStateException(SystemErrorMessages.LOTTO_TICKETS_WAS_NOT_CREATED.getMessage());
        }
        OutputView.printPurchasedLottoNumbers(lottoTickets);
    }

    private void collectWinningNumbers() {
        RetryUtil.retry(() -> winningLotto = WinningLotto.of(getWinningNumbers(), getBonusWinningNumber()));
    }

    private Lotto getWinningNumbers() {
        return Lotto.valueOf(InputView.winningLottoNumbersInput());
    }

    private LottoNumber getBonusWinningNumber() {
        return LottoNumber.valueOf(InputView.winningLottoBonusNumberInput());
    }

    private void calculateWinningResults() {
        calculateWinningResult();
        calculateTotalReturn();
    }

    private void calculateWinningResult() {
        if (lottoTickets == null) {
            throw new IllegalStateException(SystemErrorMessages.LOTTO_TICKETS_WAS_NOT_CREATED.getMessage());
        }
        if (winningLotto == null) {
            throw new IllegalStateException(SystemErrorMessages.WINNING_LOTTO_WAS_NOT_CREATED.getMessage());
        }
        winningResult = WinningResult.compare(lottoTickets, winningLotto);
    }

    private void calculateTotalReturn() {
        if (lottoPurchase == null) {
            throw new IllegalStateException(SystemErrorMessages.LOTTO_PURCHASE_WAS_NOT_CREATED.getMessage());
        }
        if (winningResult == null) {
            throw new IllegalStateException(SystemErrorMessages.WINNING_RESULT_WAS_NOT_CREATED.getMessage());
        }
        totalWinning = TotalWinning.compare(lottoPurchase, winningResult);
    }

    private void announceWinningResults() {
        announceWinningResult();
        announceTotalReturn();
    }

    private void announceWinningResult() {
        if (winningResult == null) {
            throw new IllegalStateException(SystemErrorMessages.WINNING_RESULT_WAS_NOT_CREATED.getMessage());
        }
        OutputView.printWinningResults(winningResult);
    }

    private void announceTotalReturn() {
        if (totalWinning == null) {
            throw new IllegalStateException(SystemErrorMessages.TOTAL_WINNING_WAS_NOT_CREATED.getMessage());
        }
        OutputView.printTotalReturn(totalWinning);
    }
}
