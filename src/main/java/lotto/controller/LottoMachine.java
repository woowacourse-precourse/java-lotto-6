package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private final String ERROR = "[ERROR] ";
    private final LottoService lottoService;

    public LottoMachine(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void lotto() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        int money = getPurchaseAmount();
        Lottos lottos = lottoService.buyLottos(money);
//        lottos.printLottos();
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
