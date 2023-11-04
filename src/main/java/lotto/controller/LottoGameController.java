package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputView;

public class LottoGameController {
    private Money money;
    private Lottos lottos;

    public void startGame() {
        money = Money.from(InputView.inputAmount());
        lottos = new Lottos(LottoGenerator.generateLottos(money.getLottoCount()));
    }
}
