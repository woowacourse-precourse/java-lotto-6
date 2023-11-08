package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {

    public void run() {
        LottoPurchaseMoney lottoPurchaseMoney = getLottoPurchaseMoney();
        int numberOfLottos = lottoPurchaseMoney.getNumberOfLottoAvailableForPurchase();
        Lottos userLottos = new Lottos(numberOfLottos);
        OutputView.printLottos(userLottos);
        WinningLotto winningLotto = getWinningLotto();
    }

    private WinningLotto getWinningLotto() {
        try {
            List<Integer> winningNumbers = InputView.readLottoWinningNumbers();
            int bonusNumber = InputView.readBonusNumber();
            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private LottoPurchaseMoney getLottoPurchaseMoney() {
        try {
            int inputMoney = InputView.readLottoPurchaseMoney();
            return new LottoPurchaseMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoPurchaseMoney();
        }
    }
}
