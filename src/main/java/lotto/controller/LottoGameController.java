package lotto.controller;

import static lotto.view.InputView.inputLottoBonusNumber;
import static lotto.view.InputView.inputLottoPurchaseAmount;
import static lotto.view.InputView.inputLottoWinningNumbers;

import java.util.List;
import lotto.exception.BonusNumberException;
import lotto.exception.LottoException;
import lotto.exception.PurchaseException;
import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoFactory;
import lotto.model.LottoResult;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoFactory lottoFactory = new LottoFactory();

    public void run() {
        List<Lotto> lottos = getLottos();
        OutputView.printLottos(lottos);

        LottoChecker lottoChecker = getLottoChecker();

        LottoResult lottoResult = lottoChecker.checkLottos(lottos);
        OutputView.printLottoResult(lottoResult);

        calculateEarningRate(lottoResult);
    }

    private LottoChecker getLottoChecker() {
        List<Integer> winningNumbers = inputLottoWinningNumbers();
        int bonusNumber = inputLottoBonusNumber();

        while (true) {
            try {
                return new LottoChecker(winningNumbers, bonusNumber);
            } catch (LottoException e) {
                winningNumbers = inputLottoWinningNumbers();
                System.out.println(e.getMessage());
            } catch (BonusNumberException e) {
                bonusNumber = inputLottoBonusNumber();
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> getLottos() {
        int purchaseAmount = inputLottoPurchaseAmount();
        while (true) {
            try {
                return lottoFactory.generateLottos(purchaseAmount);
            } catch (LottoException | PurchaseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calculateEarningRate(LottoResult lottoResult) {
        double earningsRate = lottoResult.getEarningsRate();
        OutputView.printEarningRate(earningsRate);
    }

}
