package lotto.domain;

public enum Match {
    FIRST(6, "1등", "6개 번호 일치", 2000000000),
    SECOND(5, "2등", "5개 번호 + 보너스 번호 일치", 30000000),
    THIRD(5, "3등", "5개 번호 일치", 1500000),
    FOURTH(4, "4등", "4개 번호 일치", 50000),
    FIFTH(3, "5등", "3개 번호 일치", 5000);

    private int numOfMatches;
    private String score;
    private String matchesInfo;
    private int price;

    Match(int numOfMatches, String score, String matchesInfo, int price) {
        this.score = score;
        this.numOfMatches = numOfMatches;
        this.matchesInfo = matchesInfo;
        this.price = price;
    }

    public String getScore() {
        return score;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }

    public String getMatchesInfo() {
        return matchesInfo;
    }

    public int getPrice() {
        return price;
    }
}
