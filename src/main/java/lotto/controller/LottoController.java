package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputMoneyView;
import lotto.view.OutputLottoCountView;

public class LottoController {

    public void start() {
        Money money = getMoney();
        Lottos lottos = createLotto(money);
    }

    private Money getMoney() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        int money = inputMoneyView.inputMoney();
        return new Money(money);
    }

    private Lottos createLotto(Money money) {
        OutputLottoCountView outputLottoCountView = new OutputLottoCountView();
        outputLottoCountView.OutputLottoCount(money);
        int lottoCount = money.getLottoCount();
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottos(lottoCount));
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
