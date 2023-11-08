package lotto.domain.service;

import lotto.domain.model.GameResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;

public class User {
    private Lottos lottos;
    private Money money ;
    public User(){

    }
    private User(Money givenMoney) {
        this.lottos = new Lottos();
        this.money = givenMoney;
    }

    public User newInstance(Money givenMoney) {
        return new User(givenMoney);
    }

    public Lottos buyLottos(int ticketAmount) {
        this.lottos = new Lottos(lottos.buyLottoByTicketAmount(ticketAmount));
        return this.lottos;
    }
    public GameResult matchUp(Lotto answer, int bonusNumber) {
        GameResult results = new GameResult(lottos.matchUp(answer,bonusNumber));
        results.countProfitable(money);
        return results;
    }
}