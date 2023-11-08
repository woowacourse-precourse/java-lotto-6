package lotto.domain;

public enum LottoRankType {
    FIVE("3개 일치", 5000),
    FOUR("4개 일치", 50000),
    THREE("5개 일치", 1500000),
    TWO("5개 일치, 보너스 볼 일치", 30000000),
    ONE("6개 일치", 2000000000);

    private final String rank;
    private final Integer rankPrice;

    LottoRankType(String rank, Integer rankPrice) {
        this.rank = rank;
        this.rankPrice = rankPrice;
    }

    public String getRank() {
        return rank;
    }

    public Integer getRankPrice() {
        return rankPrice;
    }
}
