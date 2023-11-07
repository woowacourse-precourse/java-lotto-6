package lotto.controller;

import static lotto.view.InputView.inputLottoBonusNumber;
import static lotto.view.InputView.inputLottoPurchaseAmount;
import static lotto.view.InputView.inputLottoWinningNumbers;
import static lotto.view.OutputView.printEarningRate;
import static lotto.view.OutputView.printLottoResult;
import static lotto.view.OutputView.printLottos;

import java.util.List;
import lotto.exception.BonusNumberException;
import lotto.exception.LottoException;
import lotto.exception.PurchaseException;
import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoResult;
import lotto.model.LottoShop;

public class LottoGameController {

    private final LottoShop lottoShop = new LottoShop();

    public void run() {
        final List<Lotto> lottos = getLottos();
        printLottos(lottos);

        final LottoResult lottoResult = getLottoResult(lottos);
        printLottoResult(lottoResult);

        final double earningsRate = lottoResult.getEarningsRate();
        printEarningRate(earningsRate);
    }

    private List<Lotto> getLottos() {
        int purchaseAmount = inputLottoPurchaseAmount();
        while (true) {
            try {
                return lottoShop.purchaseLottos(purchaseAmount);
            } catch (LottoException | PurchaseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoResult getLottoResult(List<Lotto> lottos) {
        final LottoChecker lottoChecker = getLottoChecker();
        return lottoChecker.checkLottos(lottos);
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

}
