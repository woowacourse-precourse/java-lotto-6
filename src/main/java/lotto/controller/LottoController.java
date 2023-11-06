package lotto.controller;

import static lotto.domain.constant.DomainConstant.ONE_LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.money.Money;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        this(new LottoGenerator());
    }

    public LottoController(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void play() {
        final UserLotto userLotto = receiveUserLotto();
        final Money purchaseAmount = new Money(userLotto.getLottoCount() * ONE_LOTTO_PRICE);
        displayUserLotto(userLotto);

        final WinningLotto winningLotto = receiveWinningLottoNumber();

        final LottoResult lottoResult = userLotto.compareAllLotto(winningLotto);

        printLottoResultStatistics(lottoResult, purchaseAmount);
    }

    private void displayUserLotto(final UserLotto userLotto) {
        final long totalLotto = userLotto.getLottoCount();
        final String allLotto = userLotto.displayAllLotto();

        outputView.printUserLotto(totalLotto, allLotto);
    }

    private UserLotto receiveUserLotto() {
        final Money purchaseAmount = receivePurchaseAmount();
        final List<Lotto> userLottoNumbers = lottoGenerator.createLottoByPrice(purchaseAmount);

        return new UserLotto(userLottoNumbers);
    }

    private Money receivePurchaseAmount() {
        try {
            outputView.requestAmount();
            final long purchaseAmount = inputView.receivePurchaseAmount();

            outputView.printNewLine();
            return new Money(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return receivePurchaseAmount();
        }
    }

    private WinningLotto receiveWinningLottoNumber() {
        final String winningNumbers = receiveWinningNumber();
        final int bonusNumber = receiveBonusNumber(winningNumbers);

        return lottoGenerator.createWinningLottoFromInput(winningNumbers, bonusNumber);
    }

    private String receiveWinningNumber() {
        try {
            outputView.requestWinningNumber();
            final String winningNumber = inputView.receiveWinningNumber();

            outputView.printNewLine();
            return winningNumber;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return receiveWinningNumber();
        }
    }

    private int receiveBonusNumber(final String winningNumbers) {
        try {
            outputView.requestBonusNumber();
            final int bonusNumber = inputView.receiveBonusNumber(winningNumbers);

            outputView.printNewLine();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return receiveBonusNumber(winningNumbers);
        }
    }

    private void printLottoResultStatistics(final LottoResult lottoResult, final Money purchaseAmount) {
        final Money totalRevenue = lottoResult.getTotalRevenue();
        outputView.printStatistics(lottoResult.getStatistics());
        outputView.printEarningRate(purchaseAmount.amount(), totalRevenue.amount());
    }
}
