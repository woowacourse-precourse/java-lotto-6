package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.MoneyManagement;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int quantity = amount();
        Lottos buyLottos = buyLotto(quantity);
        outputView.showLottoList(buyLottos);
    }

    public int amount() {
        MoneyManagement amount = getAmount();
        int quantity = amount.getQuantity();
        outputView.showTickets(quantity);
        return quantity;
    }

    public MoneyManagement getAmount() {
        outputView.askAmount();
        String purchaseAmount = inputView.read();
        return MoneyManagement.from(purchaseAmount);
    }

    public Lottos buyLotto(final int quantity) {
        return Lottos.from(quantity);
    }

}
