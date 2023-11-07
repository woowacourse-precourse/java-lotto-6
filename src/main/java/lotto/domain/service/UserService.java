package lotto.domain.service;

import lotto.domain.model.LottosResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;

public class UserService implements User {
    private Lottos lottos;
    private Money money ;
    public UserService(){

    }
    private UserService(Money givenMoney) {
        this.lottos = new Lottos();
        this.money = givenMoney;
    }

    @Override
    public User newInstance(Money givenMoney) {
        return new UserService(givenMoney);
    }
    @Override
    public Lottos buyLottos(int ticketAmount) {
        this.lottos = new Lottos(lottos.buyLottoByTicketAmount(ticketAmount));
        return this.lottos;
    }
    @Override
    public LottosResult matchUp(Lotto answer, int bonusNumber) {
        LottosResult results = new LottosResult(lottos.matchUp(answer,bonusNumber));
        results.countProfitable(money);
        return results;
    }
}
