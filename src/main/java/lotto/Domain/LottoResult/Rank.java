package lotto.Domain.LottoResult;

enum Rank {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5);

    private Integer rank;

    Rank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }
}
