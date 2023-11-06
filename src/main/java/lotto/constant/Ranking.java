package lotto.constant;

public enum Ranking {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    NOT_WIN(6);
    private final Integer ranking;

    Ranking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getRanking() {
        return ranking;
    }
}
