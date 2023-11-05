package lotto;

import static lotto.view.Inputs.getBonusNumbers;
import static lotto.view.Inputs.getPurchaseAmount;
import static lotto.view.Inputs.getWinningNumbers;
import static lotto.view.Outputs.showLottos;
import static lotto.view.Outputs.showWinningDetails;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.ResultRepository;
import lotto.domain.WinningLotto;
import lotto.service.PurchaseLotto;
import lotto.service.WinningStatistics;

public class LottoGame {
    private List<Lotto> purchaseLottos;
    private WinningLotto inputWinningLotto;
    private List<ResultRepository> results;

    public void playGame() {
        setGame();
        play();
        showResult();
    }

    private void setGame() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        purchaseLottos = purchaseLotto.purchase(getPurchaseAmount());
        showLottos(purchaseLottos);

        inputWinningLotto = new WinningLotto(getWinningNumbers(), getBonusNumbers());
    }

    private void play() {
        results = new ArrayList<>();
        for (Lotto lotto : purchaseLottos) {
            results.add(new ResultRepository(inputWinningLotto, lotto));
        }
    }

    private void showResult() {
        WinningStatistics winningStatistics = new WinningStatistics(results);
        showWinningDetails(winningStatistics);
    }
}
