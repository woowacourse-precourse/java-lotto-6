package lotto.domain;

import static lotto.domain.constants.DomainConstants.PERCENTAGE;

public class Profit {

    private final WinningLottos winningLottos;
    private final Money money;

    public Profit(WinningLottos winningLottos, Money money) {
        this.winningLottos = winningLottos;
        this.money = money;
    }

    public double calculate() {
        double sum = 0;
        for (Rank rank : Rank.values()) {
            sum += winningLottos.getPrize(rank);
        }
        return sum / money.getMoney() * PERCENTAGE;
    }
}