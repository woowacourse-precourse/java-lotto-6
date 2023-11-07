package lotto.controller;

import java.util.List;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.Score;
import lotto.domain.UserPrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public static final int LOTTO_PRICE = 1000;

    public void run() {
        UserPrice userPrice = inputUserPrice();
        Lotties lotties = buyLotties(userPrice);
        WinningNumber winningNumber = inputWinningNumber();
        Score score = new Score(winningNumber, lotties);
        int totalProfit = score.getTotalProfit();

        OutputView.printScore(score.getScore());
        OutputView.printProfit(totalProfit, userPrice.getPrice());
    }

    private static Lotties buyLotties(UserPrice userPrice) {
        Lotties lotties = userPrice.buy(LOTTO_PRICE);
        OutputView.printBuyLottoCount(lotties.size());
        OutputView.printLotties(lotties.getLottiesNumbers());
        return lotties;
    }

    private static UserPrice inputUserPrice() {
        while (true) {
            try {
                OutputView.printBuyInputPrice();
                return new UserPrice(InputView.inputUserPrice());
            } catch (IllegalArgumentException e) {
                OutputView.errorCatch(e);
            }
        }
    }

    public WinningNumber inputWinningNumber() {
        OutputView.printEnterWinningNumber();
        List<Integer> numbers = InputView.inputLottoNumbers();

        OutputView.printEnterBonusNumber();
        int bonusNumber = InputView.inputBonusNumber();

        return new WinningNumber(new Lotto(numbers), bonusNumber);
    }

}
