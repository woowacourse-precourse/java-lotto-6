package lotto.controller;

import java.util.List;
import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.util.RandomLottoGenerator;
import lotto.view.Input;

public class LottoController {
    public void start() {
        Money money = getMoney();
        LottoTickets lottoTickets = getLottoTickets(money);
        WinningLotto winningLotto = getWinningLotto();
    }

    private Money getMoney() {
        return new Money(Input.inputMoney());
    }

    private LottoTickets getLottoTickets(Money money) {
        int ticket = money.getTicket();
        return LottoTickets.generateLottoTickets(new RandomLottoGenerator(), ticket);
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningLotto = Input.inputWinningLotto();
        int bonusNumber = Input.inputBonusNumber();
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
