package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Calculator;
import lotto.domain.Lottos;
import lotto.domain.WinningChecker;
import lotto.io.Input;
import lotto.io.Output;

import java.util.List;

public class LottoController {

    public void start() {
        Output output = new Output();
        output.printInputMoneyMessage();

        Input input = new Input();
        int money = input.getMoney();
        Lottos lottos = new Lottos(money);
        output.printMyLottoCount(money);
        output.printMyLottos(lottos.makeMyLottosForPrint());

        output.printInputWinningNumbersMessage();
        List<Integer> winningNumbers = input.getWinningNumbers();
        output.printInputBonusNumberMessage();
        int bonusNumber = input.getBonusNumber();
        Console.close();

        WinningChecker winningChecker = new WinningChecker(lottos, winningNumbers, bonusNumber);
        List<Integer> matchedNumberCountEachLotto = winningChecker.countMatchedNumbersEachLotto();
        List<Integer> winningLottos = winningChecker.countWinningLottos(matchedNumberCountEachLotto);

        Calculator calculator = new Calculator(winningLottos, money);
        double profitRate = calculator.calculateProfitRate();

        output.printWinningResult(winningLottos, profitRate);
    }
}
