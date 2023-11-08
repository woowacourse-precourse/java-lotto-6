package lotto.controller;

import java.util.List;
import lotto.domain.Customer;
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
        try {
            List<Integer> winningLottoNumbers = InputView.readWinningLottoNumbers();
            int bonusNumber = InputView.readBonusNumber();
            return new WinningLotto(winningLottoNumbers, bonusNumber);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readWinningLotto();
        }
    }
}
