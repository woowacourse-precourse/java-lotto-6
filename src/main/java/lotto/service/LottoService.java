package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.User;

public class LottoService {
    public User buyLottoTicket(int buyAmount) {
        Money money = new Money(buyAmount);
        LottoTicket lottoTicket = new LottoTicket(money.getNumberOfPurchase());
        User user = new User(money, lottoTicket);
        user.spendAllMoney();
        return user;
    }
}