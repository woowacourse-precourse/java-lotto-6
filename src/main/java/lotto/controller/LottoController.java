package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        Money money = askMoney();
        List<Lotto> lottos = lottoGenerator.generateLottos(money.getCount());
    }

    private Money askMoney() {
        return new Money(inputView.requestMoney());
    }
}
