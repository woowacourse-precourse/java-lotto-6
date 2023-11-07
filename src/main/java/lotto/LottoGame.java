package lotto;

import static lotto.domain.WinningLotto.getValidBonusNumber;
import static lotto.domain.WinningLotto.getValidLottoNumbers;
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
        purchaseLottos = getValidPurchaseLottos();
        showLottos(purchaseLottos);

        Lotto validWinningLotto = makeValidWinningLotto();
        Integer validBonusNumber = makeValidBonusNumber(validWinningLotto);
        inputWinningLotto = new WinningLotto(validWinningLotto, validBonusNumber);
    }

    private Integer makeValidBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                return getValidBonusNumber(getBonusNumbers(), winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto makeValidWinningLotto() {
        while (true) {
            try {
                return getValidLottoNumbers(getWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> getValidPurchaseLottos() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        while (true) {
            try {
                return purchaseLotto.purchase(getPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
