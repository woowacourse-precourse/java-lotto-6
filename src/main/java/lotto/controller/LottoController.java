package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.PurchasedLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        lottoService = LottoService.startGame();
    }

    public void run() {
        Customer customer = inputView.getCustomer();
        PurchasedLotto purchased
                = lottoService.createLotto(customer.getLottoCount());
        outputView.printPurchasedLotto(purchased);
    }
}
