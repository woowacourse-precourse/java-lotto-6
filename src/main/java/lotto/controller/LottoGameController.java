package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private Money money;
    private Lottos lottos;

    public void startGame() {
        money = Money.from(InputView.inputAmount());
        lottos = new Lottos(LottoGenerator.generateLottos(money.getLottoCount()));
        printLottos();
    }

    private void printLottos() {
        OutputView.printLottoCountMessage(money.getLottoCount());
        for (Lotto lotto : lottos.getLottos()) {
            OutputView.printLottos(lotto.getNumber());
        }
    }
}
