package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private PurchaseAmount purchaseAmount;
    private LottoTicket lottoTicket;
    private LuckyNumbers luckyNumbers;
    private WinningResults winningResults;

    public void start() {
        set();
        lotto();
        getLottoResult();
    }

    private void set(){
        purchaseAmount = readAmount();
        lottoTicket = buyTicket();
        luckyNumbers = createLuckyNumber();
    }

    private void lotto(){
        winningResults = new WinningResults(lottoTicket, luckyNumbers);
    }

    private void getLottoResult() {
        OutputView.printResultMessage();
        OutputView.printWinningStatistic(winningResults);
        OutputView.printProfit(purchaseAmount.calculateProfit(winningResults.calculatePrizeSum()));
    }

    private PurchaseAmount readAmount() {
        try {
            return new PurchaseAmount(InputView.readPurchaseAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readAmount();
        }
    }

    private LottoTicket buyTicket() {
        int lottoCount = purchaseAmount.calculateLottoCount();
        OutputView.printLottoCount(lottoCount);

        lottoTicket = new LottoTicket(lottoCount);
        OutputView.printTicket(lottoTicket);
        return lottoTicket;
    }

    private LuckyNumbers createLuckyNumber() {
        Lotto winningNumber = readWinningNumbers();
        LottoNumber bonusNumber = readBonusNumber();

        return getLuckyNumbers(winningNumber, bonusNumber);
    }

    private Lotto readWinningNumbers() {
        try {
            return new Lotto(InputView.readWinningNumbers());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readWinningNumbers();
        }
    }

    private LottoNumber readBonusNumber() {
        try {
            return new LottoNumber(InputView.readBonusNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readBonusNumber();
        }
    }

    private LuckyNumbers getLuckyNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        try {
            return new LuckyNumbers(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getLuckyNumbers(winningNumbers, readBonusNumber());
        }

    }

}
