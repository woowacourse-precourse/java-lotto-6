package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Money money = createMoneyInput();
        int lottoCount = money.getLottoCount();
        outputView.printPurchase(lottoCount);
        Lottos lottos = createLottos(lottoCount);
        outputView.printLottos(lottos);

    }

    private Money createMoneyInput() {
        outputView.printMoneyInput();
        while (true) {
            try {
                String inputMoney = inputView.moneyInput();
                return new Money(inputMoney);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lottos createLottos(int lottoCount) {
        return Lottos.generateLottos(lottoCount);
    }
}
