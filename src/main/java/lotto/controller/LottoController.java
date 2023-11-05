package lotto.controller;

import static lotto.view.OutputView.printByLottoCount;
import static lotto.view.OutputView.printLottos;

import lotto.model.Lottos;
import lotto.model.LottosGeneratorMachine;
import lotto.model.Money;
import lotto.view.InputView;

public class LottoController {

    public void start() {
        Money money = getMoney();
        printByLottoCount(money);

        Lottos lottos = getLottos(money);
        printLottos(lottos);
    }

    private Money getMoney() {
        int money = InputView.getUserInputForLottoBuyAccount();
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        LottosGeneratorMachine lottosGeneratorMachine = new LottosGeneratorMachine();
        return new Lottos(lottosGeneratorMachine.generateLottos(money.getLottoCount()));
    }


}
