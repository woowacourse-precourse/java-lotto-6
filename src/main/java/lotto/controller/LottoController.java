package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPublisher;
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
        LottoPublisher lottoPublisher =  inputController.getPurchasePrice();
        printLottoInformation(lottoPublisher);

        WinningNumber winningNumber = inputController.getWinningNumber();
        BonusNumber bonusNumber = inputController.getBonusNumber(winningNumber.getWinningNumber());

        Lotto winningLotto = winningNumber.createWinningLotto();
        RankDeterminer lottoResult = new RankDeterminer(winningLotto, bonusNumber);
        WinningResult winningResult = new WinningResult(lottoResult.determineAllRank(lottoPublisher.getUserLottos()), lottoPublisher.getMoney());

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
        OutputView.printWinningResult(winningResult.getWinningResult());
        OutputView.printProfitRate(winningResult.getProfitRate());
    }


}
