package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        Money money = generateMoney();

        UserLotto userLotto = generatedUserLotto(money);
        repeatPrintUserLottoNumber(userLotto);

        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = calculateResult(winningLotto, userLotto);

        outputView.printPrizeResult(prizeResult.toString());
        outputView.printRate(calculateRate(money.getMoney(), prizeResult));
    }

    private Money generateMoney() {
        return new Money(inputView.getMoney());
    }

    private UserLotto generatedUserLotto(Money money) {
        int numberOfLottoTickets = money.getNumberOfLottoTickets();
        outputView.printTicket(numberOfLottoTickets);
        return new UserLotto(numberOfLottoTickets);
    }

    private void repeatPrintUserLottoNumber(UserLotto userLotto) {
        for (Lotto lotto : userLotto.getUserLottoNumbers()) {
            outputView.printUserLottoNumbers(lotto.getNumbers());
        }
        System.out.println();
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningLottoNumbers = inputView.getWinningLottoNumber();
        int bonusNumber = inputView.getBonusNumber();
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    private PrizeResult calculateResult(WinningLotto winningLotto, UserLotto userLotto) {
        PrizeResult prizeResult = new PrizeResult();
        prizeResult.calculatePrizeResult(winningLotto, userLotto);
        return prizeResult;
    }

    private Double calculateRate(int money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult).getRate();
    }
}
