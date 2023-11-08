package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoMachine lottoMachine;

    public LottoGameController() {
        this.lottoMachine = new LottoMachine();
    }

    public void play() {
        LottoTickets lottoTickets = purchaseLottoTickets();
        OutputView.printLottoTickets(lottoTickets);
        WinningNumbers winningNumbers = readWinningNumbers();
        showLottoResult(lottoTickets, winningNumbers);
    }

    private LottoTickets purchaseLottoTickets() {
        while (true) {
            try {
                int purchaseAmount = InputView.readPurchaseAmount();
                return lottoMachine.purchaseLotto(purchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e);
            }
        }
    }

    private WinningNumbers readWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(InputView.readWinningNumbers(), InputView.readBonusNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e);
            }
        }
    }

    private void showLottoResult(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        LottoResult lottoResult = calculateResult(lottoTickets, winningNumbers);
        OutputView.printWinningResult(lottoResult);
        double profitRate = lottoResult.calculateProfitRate(lottoTickets.getNumberOfTickets());
        OutputView.printProfitRate(profitRate);
    }

    private LottoResult calculateResult(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        LottoResult result = new LottoResult();
        for (Lotto ticket : lottoTickets.getTickets()) {
            LottoRank rank = winningNumbers.determineRank(ticket);
            result.recordRank(rank);
        }
        return result;
    }
}
