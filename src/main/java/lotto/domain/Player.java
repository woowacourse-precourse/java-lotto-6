package lotto.domain;

import java.util.List;

public class Player {
    private int cash;
    private int attempt;
    private List<Lotto> lottos;

    public Player(int cash) {
        validate(cash);
        this.cash = cash;
    }

    private void validate(int cash) {
        if (cash % 1000 != 0)
            throw new IllegalArgumentException();
    }

    public int getCash() {
        return this.cash;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
