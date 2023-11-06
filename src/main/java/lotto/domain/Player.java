package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int cash;
    private int attempt;
    private List<Lotto> lottos;

    public Player(int cash) {
        validate(cash);
        this.cash = cash;
        this.attempt = cash / 1000;
        this.lottos = new ArrayList<>();
    }

    public void lottoDraw() {
        for (int i = 0; i < attempt; i++) {
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
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
