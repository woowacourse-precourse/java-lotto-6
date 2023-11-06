package lotto.controller;

import static lotto.view.OutputView.printByLottoCount;
import static lotto.view.OutputView.printLottos;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.LottosGeneratorMachine;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
import lotto.model.WinningStandard;
import lotto.view.InputView;

public class LottoController {

    public void start() {
        Money money = getMoney();
        printByLottoCount(money);

        Lottos lottos = generateLottos(money);
        printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();
        WinningResult winningResult = calculateWinningResult(lottos, winningLotto);

        winningResult.getWinningResult().entrySet().forEach(System.out::println);
    }

    private WinningResult calculateWinningResult(Lottos lottos, WinningLotto winningLotto) {
        List<Lotto> purchasedLottos = lottos.getLottos();
        WinningResult winningResult = new WinningResult();

        for (Lotto lotto : purchasedLottos) {
            WinningStandard ranking = WinningStandard.checkMatchNumbers(lotto, winningLotto);
            winningResult.addResult(ranking, 1);
        }
        return winningResult;
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
