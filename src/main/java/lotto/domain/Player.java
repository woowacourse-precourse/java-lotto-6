package lotto.domain;

public class Player {
    private final Money money;
    private final Lottos lottos;

    public Player(Money money, Lottos lottos) {
        validateMoneyMatchesLottos(money, lottos);
        this.money = money;
        this.lottos = lottos;
    }

    private void validateMoneyMatchesLottos(Money money, Lottos lottos) {
        if (money.getAmount() / LottoMachine.getLottoPrice() != lottos.getSize()) {
            throw new IllegalStateException();
        }
    }

    public Money getMoney() {
        return money;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
