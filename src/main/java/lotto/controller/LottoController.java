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
        final Money purchaseAmount = getPurchaseAmount();
        final UserLotto userLotto = getUserLotto(purchaseAmount);
        displayUserLotto(userLotto);

        final WinningLotto winningLotto = getWinningLotto();

        final LottoResult lottoResult = userLotto.compareAllLotto(winningLotto);
        displayLottoResult(purchaseAmount, lottoResult);
    }

    private Money getPurchaseAmount() {
        return new Money(lottoViewController.receivePurchaseAmount());
    }

    private UserLotto getUserLotto(final Money purchaseAmount) {
        final List<Lotto> userLottoNumbers = lottoGenerator.createLottoByPrice(purchaseAmount);
        return new UserLotto(userLottoNumbers);
    }

    private void displayUserLotto(final UserLotto userLotto) {
        final long lottoCount = userLotto.getLottoCount();
        final String allLotto = userLotto.toString();

        lottoViewController.printUserLotto(lottoCount, allLotto);
    }

    private WinningLotto getWinningLotto() {
        final String winningNumbers = lottoViewController.receiveWinningNumber();
        final Integer bonusNumber = lottoViewController.receiveBonusNumber(winningNumbers);

        return lottoGenerator.createWinningLottoFromInput(winningNumbers, bonusNumber);
    }

    private void displayLottoResult(final Money purchaseAmount, final LottoResult lottoResult) {
        final List<Long> winCounts = lottoResult.getWinCountOfEachPrize();

        final Money totalRevenue = lottoResult.getTotalRevenue();
        final double earningRate = totalRevenue.getPercentageOf(purchaseAmount);

        lottoViewController.printResultMessage(winCounts, earningRate);
    }
}
