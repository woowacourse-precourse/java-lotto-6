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
        Lotto winningNumbers = getWinningNumbers();
        WinningLotto winningLotto = getWinningLotto(winningNumbers);
        Result result = getResult(userLottos, winningLotto);
        OutputView.printResult(result);
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

    private Lotto getWinningNumbers() {
        try {
            List<Integer> winningNumbers = InputView.readLottoWinningNumbers();
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private WinningLotto getWinningLotto(Lotto winningNumbers) {
        try {
            LottoNumber bonusNumber = new LottoNumber(InputView.readBonusNumber());
            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningLotto(winningNumbers);
        }
    }

    private LottoPurchaseMoney getLottoPurchaseMoney() {
        try {
            int inputMoney = InputView.readLottoPurchaseMoney();
            return new LottoPurchaseMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getLottoPurchaseMoney();
        }
    }
}
