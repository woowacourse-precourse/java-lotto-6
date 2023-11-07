package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputMoneyView;
import lotto.view.OutputLottoCountView;

public class LottoController {

    public void start() {
        Money money = getMoney();
        printLottoCount(money);
        Lottos lottos = createLottos(money);
        printLottos(lottos);
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
    }

    private void getNumber() {

    }

    private void getBonusNumber() {

    }

    private void calculateWin() {

    }

    private void calculateRate() {

    }
}
