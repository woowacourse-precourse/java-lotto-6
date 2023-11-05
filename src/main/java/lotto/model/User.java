package lotto.model;

import java.util.List;

public class User {
    private Lottos lottos = new Lottos();
    private final Money money ;
    public User(Money givenMoney) {
        this.money = givenMoney;
    }

    public Lottos buyLottos(int ticketAmount) {
        List<Lotto> returnLottos = lottos.buyLottoByTicketAmount(ticketAmount);
        this.lottos = new Lottos(returnLottos);
        return this.lottos;
    }

    public LottosResult matchUp(Lotto answer, int bonusNumber) {
        LottosResult results = lottos.matchUp(answer,bonusNumber);
        results.countProfitable(money);
        return results;
    }
}