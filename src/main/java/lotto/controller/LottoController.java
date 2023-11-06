package lotto.controller;

import static lotto.view.OutputView.printByLottoCount;
import static lotto.view.OutputView.printLottos;

import java.util.List;
import lotto.model.Lottos;
import lotto.model.LottosGeneratorMachine;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.view.InputView;

public class LottoController {

    public void start() {
        Money money = getMoney();
        printByLottoCount(money);

        Lottos lottos = generateLottos(money);
        printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = InputView.getUserInputForWinningNumbers();
        int bonusNumber = InputView.getUserInputForBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Money getMoney() {
        int money = InputView.getUserInputForLottoBuyAccount();
        return new Money(money);
    }

    private Lottos generateLottos(Money money) {
        LottosGeneratorMachine lottosGeneratorMachine = new LottosGeneratorMachine();
        return new Lottos(lottosGeneratorMachine.generateLottos(money.getLottoCount()));
    }
}
