package lotto.util;

public enum MatchRanking {
    FIRST_PLACE(6, "1등", 2000000000),
    SECOND_PLACE(6, "2등", 30000000),
    THIRD_PLACE(5, "3등", 1500000),
    FOURTH_PLACE(4, "4등", 50000),
    FIFTH_PLACE(3, "5등", 5000),
    NO_MATCH(0, "", 0);

    private Integer countMatchNumber;
    private String rank;
    private Integer money;

    MatchRanking(Integer countMatchNumber, String rank, Integer money) {
        this.countMatchNumber = countMatchNumber;
        this.rank = rank;
        this.money = money;
    }

    public Integer getCountMatchNumber() {
        return countMatchNumber;
    }

    public String getRank() {
        return rank;
    }

    public Integer getMoney() {
        return money;
    }
}
