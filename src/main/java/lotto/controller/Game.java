package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Game {
    public void startLottoGame() {
        int money = InputView.inputLottoAmount();
        LottoCashier lottoCashier = new LottoCashier();

        int count = lottoCashier.getLottoCount(money);
        OutputView.printCheckAmount(count);

        List<Lotto> lottos = lottoCashier.createLottoList(count);
        OutputView.printPurchasedNumbers(lottos);

        WinningNumbers winningNumbers = (WinningNumbers) InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        Referee referee = new Referee(lottos,winningNumbers,bonusNumber);
        List<Grade> grades = referee.calculateGrades();
        OutputView.printLottoStatics(referee.getStatics(grades));

        Yield yield = new Yield(grades, money);
        OutputView.printLottoEarningRate(yield.getYield());
    }
}
