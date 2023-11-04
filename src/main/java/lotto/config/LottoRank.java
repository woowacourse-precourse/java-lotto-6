package lotto.config;

public enum LottoRank {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    LOSE(-1);

    private final Integer num;

    LottoRank(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }
}
