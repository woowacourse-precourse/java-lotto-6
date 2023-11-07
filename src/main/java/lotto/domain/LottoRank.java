package lotto.domain;

public enum LottoRank {
    MATCH_3(3, "5,000"),
    MATCH_4(4, "50,000"),
    MATCH_5(5, "1,500,000"),
    MATCH_5_BONUS(5, "30,000,000"),
    MATCH_6(6, "2,000,000,000");

    private int matchingCount;
    private String reword;

    LottoRank(int matchingCount, String reword) {
        this.matchingCount = matchingCount;
        this.reword = reword;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public String getReword() {
        return reword;
    }

    public int getRewordByInt() {
        return Integer.parseInt(reword.replaceAll(",", ""));
    }
}
