package lotto.model;

import java.util.List;

public class User {
    private Lottos lottos;
    private final int money ;
    public User(int givenMoney) {
        this.money = givenMoney;
    }

    public Lottos buyLottos(int ticketAmount) {
        this.lottos = Lottos.generateLottos(ticketAmount);
        return lottos;
    }

    public GameResult matchLottos(Lotto answer, int bonusNumber) {
        List<LottoResult> results = lottos.matchLottos(answer,bonusNumber);
        GameResult gameResult = new GameResult(results);
        gameResult.countProfitable(money);
        return gameResult;
    }
}
