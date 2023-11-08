package lotto.controller;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoResult;
import lotto.domain.RandomLottoFactory;
import lotto.domain.WinningLotto;
import lotto.view.input.InputView;

public class MainController {
    public static void start() {
        LottoPurchaseAmount lottoPurchaseAmount = readLottoPurchaseAmount();
        Customer customer = Customer.of(lottoPurchaseAmount, new RandomLottoFactory());

        WinningLotto winningLotto = readWinningLotto();
        LottoResult lottoResult = winningLotto.result(customer);
    }

    private static LottoPurchaseAmount readLottoPurchaseAmount() {
        int lottoPurchasePrice = InputView.readLottoPurchasePrice();
        return LottoPurchaseAmount.from(lottoPurchasePrice);
    }

    private static WinningLotto readWinningLotto() {
        List<Integer> winningLottoNumbers = InputView.readWinningLottoNumbers();
        int bonusNumber = InputView.readBonusNumber();
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }
}
