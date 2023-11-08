package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.PurchasedLotto;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private LottoService lottoService;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
        lottoService = LottoService.startGame();
    }

    public void run() {
        Customer customer = inputView.getCustomer();
        PurchasedLotto purchased
                = lottoService.createLotto(customer.getLottoCount());

    }
}
