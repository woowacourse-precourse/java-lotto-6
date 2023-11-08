package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static List<Lotto> myLottos = new ArrayList<>();
    public static Lotto winningLotto;
    public static int bonusNumber;
    public static int[] resultCounter = new int[6];

    public void play() {
        OutputView.printAskMoneyMessage();
        Money money = new Money(InputView.inputMoney());
        buyLottos(money.trial);
        OutputView.printAskWinningNumbersMessage();
        winningLotto = new Lotto(InputView.inputWinningNumbers());
        OutputView.printAskBonusNumberMessage();
        bonusNumber = InputView.inputBonusNumber();
        OutputView.printAlertResultMessage();
        Winning.check();
        calculateReturnRate(money.amount);
    }

    public void buyLottos(int trial) {
        OutputView.printNoticeTrialMessage(trial);
        do {
            List<Integer> numbers = LottoNumber.pickRandomNumbers(6);
            myLottos.add(new Lotto(numbers));
        } while (myLottos.size() < trial);
        OutputView.printBoughtLottos(myLottos);
    }

    public void calculateReturnRate(int inputMoney) {
        double profit = 0;
        double returnRate;
        for (int index = 0; index < 5; index++) {
            Winning winning = Winning.values()[index];
            profit += winning.getReward() * resultCounter[index];
        }
        returnRate = profit / inputMoney * 100;
        OutputView.printReturnRate(returnRate);
    }
}
