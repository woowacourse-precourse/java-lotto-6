package lotto.controller;

import java.util.EnumMap;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Purchase;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.strategy.AutoIssuanceStrategy;
import lotto.domain.strategy.ManualIssuanceStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        playLottoGame();
    }

    private void playLottoGame() {
        Purchase purchase = getPurchaseAmount();
        Lottos lottos = issueLottosByAuto(purchase.calculatePurchasedLottoCount());
        printPurchaseHistory(purchase, lottos);

        WinningLotto winningLotto = issueWinningLottoByManual(getWinningLotto());
        EnumMap<Rank, Integer> rankResult = lottos.getRankResult(winningLotto);
        double yield = purchase.calculateYield(lottos.calculateTotalReward(rankResult));
        printLottoGameResult(rankResult, yield);
    }

    private Purchase getPurchaseAmount() {
        OutputView.printPurchaseGuide();
        try {
            return new Purchase(InputView.readInput());
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printErrorMessage(illegalArgumentException.getMessage());
            return getPurchaseAmount();
        }
    }

    private Lottos issueLottosByAuto(final int totalCount) {
        return new Lottos(totalCount, new AutoIssuanceStrategy());
    }

    private void printPurchaseHistory(final Purchase purchase, final Lottos lottos) {
        OutputView.printPurchasedLottoCount(purchase.calculatePurchasedLottoCount());
        OutputView.printIssuedLottosNumbers(lottos.getLottoNumbersDto());
    }

    private WinningLotto issueWinningLottoByManual(final Lotto winningLotto) {
        try {
            return new WinningLotto(winningLotto, getBonusNumber());
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printErrorMessage(illegalArgumentException.getMessage());
            return issueWinningLottoByManual(winningLotto);
        }
    }

    private Lotto getWinningLotto() {
        OutputView.printWinningLottoNumbersGuide();
        try {
            String winningLottoNumbers = InputView.readInput();
            return issueLottoByManual(winningLottoNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printErrorMessage(illegalArgumentException.getMessage());
            return getWinningLotto();
        }
    }

    private Lotto issueLottoByManual(final String winningLottoNumbers) {
        return new ManualIssuanceStrategy(winningLottoNumbers).issue();
    }

    private int getBonusNumber() {
        OutputView.printBonusNumberGuide();
        return Integer.parseInt(InputView.readInput());
    }

    private void printLottoGameResult(final EnumMap<Rank, Integer> rankResult, final double yield) {
        OutputView.printWinningStatistics(rankResult);
        OutputView.printTotalYield(yield);
    }

}
