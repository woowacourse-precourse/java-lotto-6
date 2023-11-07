package lotto.domain.common;

public enum Rank {

    FIFTH("3개 일치 (5,000원)", 3),
    FOURTH("4개 일치 (50,000원)", 4),
    THIRD("5개 일치 (1,500,000원)", 5),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5),
    FIRST("6개 일치 (2,000,000,000원)", 6);

    private final String info;
    private final Integer matchCount;

    Rank(String info, Integer matchCount) {
        this.info = info;
        this.matchCount = matchCount;
    }

    public String getInfo() {
        return info;
    }

    public Integer getMatchCount() {
        return matchCount;
    }
}
