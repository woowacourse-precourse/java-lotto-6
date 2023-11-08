package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoResult;
import lotto.domain.RandomLottoFactory;
import lotto.domain.WinningLotto;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class MainController {
    public static void start() {
        LottoPurchaseAmount lottoPurchaseAmount = readLottoPurchaseAmount();
        Customer customer = Customer.of(lottoPurchaseAmount, new RandomLottoFactory());
        OutputView.printPurchasedLottos(customer);

        WinningLotto winningLotto = readWinningLotto();
        LottoResult lottoResult = winningLotto.result(customer);
        OutputView.printLottoResult(lottoResult);
        OutputView.printPrizeRate(lottoResult);
    }

    private static LottoPurchaseAmount readLottoPurchaseAmount() {
        try {
            int lottoPurchasePrice = InputView.readLottoPurchasePrice();
            return LottoPurchaseAmount.from(lottoPurchasePrice);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readLottoPurchaseAmount();
        }
    }

    private static WinningLotto readWinningLotto() {
        Lotto winningLottoNumbers = readWinningLottoNumbers();
        OutputView.printNewLine();
        LottoNumber bonusNumber = readBonusNumber();
        return createWinningLotto(winningLottoNumbers, bonusNumber);
    }

    private static Lotto readWinningLottoNumbers() {
        try {
            return new Lotto(InputView.readWinningLottoNumbers());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readWinningLottoNumbers();
        }
    }

    private static LottoNumber readBonusNumber() {
        try {
            return LottoNumber.from(InputView.readBonusNumber());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readBonusNumber();
        }
    }

    private static WinningLotto createWinningLotto(Lotto winningLottoNumbers, LottoNumber bonusNumber) {
        try {
            return new WinningLotto(winningLottoNumbers, bonusNumber);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return createWinningLotto(winningLottoNumbers, readBonusNumber());
        }
    }
}
