package lotto.util;

public enum MatchRanking {
    FIRST_PLACE("1등", 2000000000),
    SECOND_PLACE("2등", 30000000),
    THIRD_PLACE("3등", 1500000),
    FOURTH_PLACE("4등", 50000),
    FIFTH_PLACE("5등", 5000),
    NO_MATCH("", 0);

    private String rank;
    private Integer money;

    MatchRanking(String rank, Integer money){
        this.rank = rank;
        this.money = money;
    }

    public String getRank(){
        return rank;
    }

    public Integer getMoney() {
        return money;
    }
}
