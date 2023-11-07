package lotto.controller;

import static lotto.view.InputView.inputLottoBonusNumber;
import static lotto.view.InputView.inputLottoWinningNumbers;

import java.util.List;
import lotto.exception.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoFactory;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoFactory lottoFactory = new LottoFactory();

    public void run() {
        List<Lotto> lottos = getLottos();
        OutputView.printLottos(lottos);

        int bonusNumber = getBonusNumber();
        LottoChecker lottoChecker = new LottoChecker(getWinningLotto(),
            bonusNumber);
        LottoResult lottoResult = lottoChecker.checkLottos(lottos);
        OutputView.printLottoResult(lottoResult);

        calculateEarningRate(lottoResult);
    }

    private static int getBonusNumber() {
        try {
            return inputLottoBonusNumber();
        } catch (LottoException e) {
            return getBonusNumber();
        }
    }

    private static Lotto getWinningLotto() {
        try {
            return new Lotto(inputLottoWinningNumbers());
        } catch (LottoException e) {
            return getWinningLotto();
        }
    }

    private List<Lotto> getLottos() {
        try {
            int purchaseAmount = InputView.inputLottoPurchaseAmount();
            return lottoFactory.generateLottos(purchaseAmount);
        } catch (LottoException e) {
            return getLottos();
        }
    }

    private void calculateEarningRate(LottoResult lottoResult) {
        double earningsRate = lottoResult.getEarningsRate();
        OutputView.printEarningRate(earningsRate);
    }

}
