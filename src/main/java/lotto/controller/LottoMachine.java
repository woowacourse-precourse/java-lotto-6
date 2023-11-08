package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private static final String ERROR = "[ERROR] ";
    private final LottoService lottoService;

    public LottoMachine(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void lotto() {
        Lottos lottos = purchaseLotto();
        OutputView.printLottos(lottos);

    }

    private Lottos purchaseLotto() {
        int money = getPurchaseAmount();
        Lottos lottos = lottoService.buyLottos(money);

        return lottos;
    }

    private int getPurchaseAmount() {
        boolean isDone = false;
        int money = 0;

        do {
            try {
                String inputValue = InputView.inputPurchaseAmount();
                lottoService.validateIsNumeric(inputValue);

                money = Integer.parseInt(inputValue);
                lottoService.validateMoney(money);

                isDone = true;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(ERROR + e.getMessage());
            }
        } while (!isDone);

        return money;
    }
}
