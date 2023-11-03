package lotto.controller;

import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.util.RandomLottoGenerator;
import lotto.view.Input;

public class LottoController {
    public void start() {
        Money money = getMoney();
        LottoTickets lottoTickets = getLottoTickets(money);
    }

    private Money getMoney() {
        return new Money(Input.inputMoney());
    }

    private LottoTickets getLottoTickets(Money money) {
        int ticket = money.getTicket();
        return LottoTickets.generateLottoTickets(new RandomLottoGenerator(), ticket);
    }
}
