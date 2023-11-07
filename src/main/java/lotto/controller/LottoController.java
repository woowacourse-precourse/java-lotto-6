package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPublisher;
import lotto.domain.LottoRank;
import lotto.domain.RankDeterminer;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.view.OutputView;

public class LottoController {
    private final InputController inputController;

    public LottoController() {
        inputController = new InputController();
        playLottoGame();
    }

    private void playLottoGame() {
        LottoPublisher lottoPublisher = inputController.getPurchasePrice();
        printLottoInformation(lottoPublisher);

        WinningNumber winningNumber = inputController.getWinningNumber();
        BonusNumber bonusNumber = inputController.getBonusNumber(winningNumber.getWinningNumber());

        Lotto winningLotto = winningNumber.createWinningLotto();
        RankDeterminer lottoResult = new RankDeterminer(winningLotto, bonusNumber);
        WinningResult winningResult = new WinningResult(lottoResult.determineAllRank(lottoPublisher.getUserLottos()),
                lottoPublisher.getMoney());

        printWinningInformation(winningResult);
    }

    private void printLottoInformation(LottoPublisher lottoPublisher) {
        OutputView.printPurchaseCount(lottoPublisher.getLottoAmount());
        printLotto(lottoPublisher.getUserLottos());
    }

    private void printLotto(List<Lotto> userLottos) {
        for (Lotto lotto : userLottos) {
            OutputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void printWinningInformation(WinningResult winningResult) {
        OutputView.printWinningStatus();
        showNonDefaultWinningResults(winningResult.getWinningResult());
        OutputView.printProfitRate(winningResult.getProfitRate());
    }

    private void showNonDefaultWinningResults(Map<LottoRank, Integer> winningResult) {
        winningResult.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(LottoRank.DEFAULT))
                .forEach(entry -> showRankResult(winningResult, entry.getKey()));
    }

    private void showRankResult(Map<LottoRank, Integer> winningResult, LottoRank rank) {
        if (rank.equals(LottoRank.SECOND)) {
            OutputView.printSecondWinningResult(winningResult, rank);
        }
        OutputView.printWinningResult(winningResult, rank);
    }
}
