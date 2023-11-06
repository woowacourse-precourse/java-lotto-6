package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.money.Money;

public class LottoController {
    private final LottoViewController lottoViewController;
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        this(new LottoViewController(), new LottoGenerator());
    }

    public LottoController(final LottoViewController lottoViewController, final LottoGenerator lottoGenerator) {
        this.lottoViewController = lottoViewController;
        this.lottoGenerator = lottoGenerator;
    }

    public void play() {
        final Money purchaseAmount = receivePurchaseAmount();
        final UserLotto userLotto = receiveUserLotto(purchaseAmount);
        displayUserLotto(userLotto);

        final WinningLotto winningLotto = receiveWinningLotto();

        final LottoResult lottoResult = userLotto.compareAllLotto(winningLotto);
        displayLottoResult(purchaseAmount, lottoResult);
    }

    private Money receivePurchaseAmount() {
        return new Money(lottoViewController.receivePurchaseAmount());
    }

    private UserLotto receiveUserLotto(final Money purchaseAmount) {
        final List<Lotto> userLottoNumbers = lottoGenerator.createLottoByPrice(purchaseAmount);
        return new UserLotto(userLottoNumbers);
    }

    private void displayUserLotto(final UserLotto userLotto) {
        final long lottoCount = userLotto.getLottoCount();
        final String allLotto = userLotto.toString();

        lottoViewController.displayUserLotto(lottoCount, allLotto);
    }

    private WinningLotto receiveWinningLotto() {
        final String winningNumbers = lottoViewController.receiveWinningNumber();
        final int bonusNumber = lottoViewController.receiveBonusNumber(winningNumbers);

        return lottoGenerator.createWinningLottoFromInput(winningNumbers, bonusNumber);
    }

    private void displayLottoResult(final Money purchaseAmount, final LottoResult lottoResult) {
        final List<Long> winCounts = lottoResult.getWinCountOfEachPrize();

        final Money totalRevenue = lottoResult.getTotalRevenue();
        final double earningRate = totalRevenue.getPercentageOf(purchaseAmount);

        lottoViewController.printResultMessage(winCounts, earningRate);
    }
}
