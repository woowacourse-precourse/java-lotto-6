package lotto.domain;

public class Player {
    private final Money money;
    private final Lottos lottos;

    public Player(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public Money getMoney() {
        return money;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
