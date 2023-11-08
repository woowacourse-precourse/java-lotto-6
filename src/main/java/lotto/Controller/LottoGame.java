package lotto.Controller;

import lotto.Model.Bonus;
import lotto.Model.RandomLottos;
import lotto.Model.Price;
import lotto.Model.Rate;
import lotto.Model.Result;
import lotto.Model.WinningLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    public void start() {
        Price price = createPrice();
        RandomLottos randomLottos = new RandomLottos(price);
        print(randomLottos);

        WinningLotto winningLotto = createWinningLotto();
        Bonus bonus = createBonusNumber(winningLotto);

        Result result = new Result();
        result.countWinningRank(randomLottos, winningLotto, bonus);
        Rate rate = new Rate(result);

        OutputView.printWinningStatistics(result);
        OutputView.printWinningRate(rate.calculateWinningRate(price));
    }

    private void print(RandomLottos randomLottos) {
        OutputView.newLine();
        OutputView.printCounting(randomLottos);
        OutputView.printNumbers(randomLottos);
    }

    private Price createPrice() {
        try {
            return new Price(InputView.inputPriceForPurchasingLotto());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            OutputView.newLine();
            return createPrice();
        }
    }

    private WinningLotto createWinningLotto() {
        try {
            return new WinningLotto(InputView.inputWinningLotto());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createWinningLotto();
        }
    }

    private Bonus createBonusNumber(WinningLotto winningLotto) {
        try {
            return new Bonus(InputView.inputBonusNumber(), winningLotto);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createBonusNumber(winningLotto);
        }
    }
}
