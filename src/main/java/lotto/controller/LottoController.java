package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.domain.Result;
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
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        Result result = getResult(userLottos, winningNumbers, bonusNumber);
        OutputView.printResult(result.getResult(), result.calculateRateOfReturn(lottoPurchaseMoney));
    }

    private Result getResult(Lottos userLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        Result result = new Result();
        userLottos.getLottos().forEach(
                lotto -> {
                    Ranking ranking = Ranking.getRanking(
                            winningNumbers.countMatchNumbers(lotto), bonusNumber.isIn(lotto));
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

    private BonusNumber getBonusNumber(Lotto winningNumbers) {
        try {
            return new BonusNumber(InputView.readBonusNumber(), winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
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
