package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWallet;
import lotto.domain.LottoWalletGenerator;
import lotto.domain.Money;
import lotto.view.MoneyInputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        Money money = getMoney();
        LottoWallet lottoWallet = buyLotto(money.getTicket());
    }

    private Money getMoney() {
        MoneyInputView moneyInputView = new MoneyInputView();
        while (true) {
            try {
                outputView.printMoneyInputMessage();
                long moneyInput = moneyInputView.readMoneyInput();
                return new Money(moneyInput);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private LottoWallet buyLotto(long ticket) {
        outputView.println();
        outputView.printTicket(ticket);
        List<Lotto> wallet = LottoWalletGenerator.generateLottoWallet(ticket);
        outputView.printLottoList(wallet);
        return new LottoWallet(wallet);
    }
}
