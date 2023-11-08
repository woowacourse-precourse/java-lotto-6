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
        getResult(userLottos, winningLotto);
    }

    private Result getResult(Lottos userLottos, WinningLotto winningLotto) {
        Result result = new Result();
        userLottos.getLottos().forEach(
                lotto -> {
                    int countMatchNumbers = winningLotto.countMatchNumbers(lotto);
                    boolean hasBonusNumber = winningLotto.hasBonusNumber(lotto);
                    Ranking ranking = Ranking.getRanking(countMatchNumbers, hasBonusNumber);
                    result.put(ranking);
                }
        );
        return result;
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
