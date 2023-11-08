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
import lotto.model.LottoResult;
import lotto.model.LottoShop;
import lotto.model.WinningLotto;

public class LottoGameController {

    private final LottoShop lottoShop = new LottoShop();

    public void run() {
        final List<Lotto> lottos = purchaseLottos();
        printLottos(lottos);

        final LottoResult lottoResult = getLottoResult(lottos);
        printLottoResult(lottoResult);

        final double earningsRate = lottoResult.getEarningsRate();
        printEarningRate(earningsRate);
    }

    private List<Lotto> purchaseLottos() {
        while (true) {
            try {
                final int purchaseAmount = inputLottoPurchaseAmount();
                return lottoShop.purchase(purchaseAmount);
            } catch (LottoException | PurchaseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoResult getLottoResult(List<Lotto> lottos) {
        final WinningLotto winningLotto = getWinningLotto();
        return winningLotto.checkLottos(lottos);
    }

    private WinningLotto getWinningLotto() {
        final Lotto winningNumbersLotto = getWinningNumbersLotto();
        int bonusNumber = inputLottoBonusNumber();
        while (true) {
            try {
                return new WinningLotto(winningNumbersLotto, bonusNumber);
            } catch (BonusNumberException e) {
                System.out.println(e.getMessage());
                bonusNumber = inputLottoBonusNumber();
            }
        }
    }

    private static Lotto getWinningNumbersLotto() {
        while (true) {
            try {
                return new Lotto(inputLottoWinningNumbers());
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
