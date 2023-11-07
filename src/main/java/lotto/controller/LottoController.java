package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputMoneyView;
import lotto.view.InputWinningNumberView;
import lotto.view.OutputLottoCountView;
import lotto.view.OutputLottosView;

import java.util.List;

public class LottoController {

    public void start() {
        Money money = getMoney();
        printLottoCount(money);
        Lottos lottos = createLottos(money);
        printLottos(lottos);
        Lotto winningNumber = getNumber();
    }

    private Money getMoney() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        int money = inputMoneyView.inputMoney();
        return new Money(money);
    }

    private void printLottoCount(Money money) {
        OutputLottoCountView outputLottoCountView = new OutputLottoCountView();
        outputLottoCountView.OutputLottoCount(money);
    }

    private Lottos createLottos(Money money) {
        int lottoCount = money.getLottoCount();
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottos(lottoCount));
    }

    private void printLottos(Lottos lottos) {
        OutputLottosView outputLottosView = new OutputLottosView();
        outputLottosView.OutputLottos(lottos);
    }

    private Lotto getNumber() {
        InputWinningNumberView inputWinningNumberView = new InputWinningNumberView();
        List<Integer> winningNumber = inputWinningNumberView.inputWinningNumber();
        return new Lotto(winningNumber);
    }

    private void getBonusNumber() {

    }

    private void calculateWin() {

    }

    private void calculateRate() {

    }
}
