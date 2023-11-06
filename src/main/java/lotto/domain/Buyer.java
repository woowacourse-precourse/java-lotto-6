package lotto.domain;

public class Buyer {
    private Lottos lottos;

    public Buyer(Lottos lottos) {
        this.lottos = lottos;
    }

    public int lottoCount() {
        return this.lottos.lottoCount();
    }
}