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

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void gameStart() {
        Money money = generatedMoney();
        int numberOfLottoTickets = money.getNumberOfLottoTickets();

        UserLotto userLotto = generatedUserLotto(numberOfLottoTickets);
        outputView.printCount(numberOfLottoTickets);

        repeatPrintUserLottoNumber(userLotto);

        List<Integer> winningLottoNumbers = inputView.getWinningLottoNumbers();
        int bonusNumber = inputView.getBonusNumber();
        WinningLotto winningLotto = generatedWinningLotto(winningLottoNumbers, bonusNumber);

        PrizeResult prizeResult = calculateResult(winningLotto, userLotto);
        outputView.printPrizeResult(prizeResult.toString());

        Rate rate = generatedRate(money.getMoney(), prizeResult);
        outputView.printRate(rate.getRate());
    }

    private Money generatedMoney() {
        return new Money(inputView.purchaseAmount());
    }

    private UserLotto generatedUserLotto(int ticket) {
        return new UserLotto(ticket);
    }

    private void repeatPrintUserLottoNumber(UserLotto userLotto) {
        for (Lotto lotto : userLotto.getUserLottoNumber()) {
            outputView.printUserLottoNumbers(lotto.getNumbers());
        }
        System.out.println();
    }

    private WinningLotto generatedWinningLotto(List<Integer> winNumber, int bonusNumber) {
        return new WinningLotto(winNumber, bonusNumber);
    }

    private PrizeResult calculateResult(WinningLotto winningLotto, UserLotto userLotto) {
        PrizeResult prizeResult = new PrizeResult();
        prizeResult.calculatePrizeResult(winningLotto, userLotto);
        return prizeResult;
    }

    private Rate generatedRate(int purchaseAmount, PrizeResult lottoResult) {
        return new Rate(purchaseAmount, lottoResult);
    }
}
