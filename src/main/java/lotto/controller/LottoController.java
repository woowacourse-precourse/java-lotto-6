package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static lotto.view.OutputView.printStatistics;

public class LottoController {

    public void startGame() {

        Money money = getLottoMoney();
        OutputView.outputCountMsg(money);

        Lottos lottos = getLottos(money);
        OutputView.printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = new PrizeResult();
        OutputView.outputResultMsg();
        showLottoResult(prizeResult, winningLotto, lottos);

        Rate rate = getRate(money,prizeResult);
        printStatistics(prizeResult, rate);
    }

    private Rate getRate(Money money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult);
    }

    private void showLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, Lottos lottos) {
        prizeResult.calculateResult(winningLotto, lottos);
    }

    private WinningLotto getWinningLotto() {

        InputView.inputNumberMsg();
        String inputNumber = Console.readLine();
        int[] winningNums = Arrays.stream(inputNumber.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        InputView.inputBonusNumberMsg();
        String inputBonusNumber = Console.readLine();
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        List<Integer> winningNumbers = Arrays.stream(winningNums)
                .boxed()
                .collect(Collectors.toList());
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lottos getLottos(Money money) {

        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(money.getLottoCount()));
    }

    private Money getLottoMoney() {

        InputView.inputPaymentMsg();
        String inputMoney = Console.readLine();
        return new Money(parseInt(inputMoney));
    }
}
