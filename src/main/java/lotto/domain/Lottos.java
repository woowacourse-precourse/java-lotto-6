package lotto.domain;

public class Lottos {
    private final Lotto lotto;
    private Rank rank;

    public Lottos(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
