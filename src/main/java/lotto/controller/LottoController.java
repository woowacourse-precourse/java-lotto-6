package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.MoneyManagement;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
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
        WinningLotto winningLotto = initWinningLotto();
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

    public Lotto askWinningNumbers() {
        outputView.askWinningNum();
        String inputWinningNumber = inputView.read();
        return createWinningNumberList(inputWinningNumber);
    }

    public Lotto createWinningNumberList(String userInput) {
        return Lotto.from(userInput);
    }

    public Number askWinningBonusNumber() {
        outputView.askBonusNum();
        String inputBonusNumber = inputView.read();
        return createWinningBonusNumber(inputBonusNumber);
    }

    public Number createWinningBonusNumber(String userInput) {
        return Number.from(userInput);
    }

    public WinningLotto initWinningLotto() {
        Lotto lotto = askWinningNumbers();
        Number number = askWinningBonusNumber();
        return new WinningLotto(lotto, number);
    }
}
