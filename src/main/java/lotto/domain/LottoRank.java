package lotto.domain;

public enum LottoRank {
    RANK2(30000000, 2),
    RANK5(5000, 5),
    RANK4(50000, 4),
    RANK3(1500000, 3),
    RANK1(2000000000, 1);


    private final Integer money;
    private Integer rank;

    LottoRank(Integer money, Integer rank) {
        this.money = money;
        this.rank = rank;
    }

    public int getMoney() {
        return money;
    }

    public Integer getRank() {
        return rank;
    }

}
