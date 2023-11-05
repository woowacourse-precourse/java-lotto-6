package lotto.domain;

public enum LottoResult {
    matches3("3개 일치 (5,000원)", 5000, 0),
    matches4("4개 일치 (50,000원)", 50000, 0),
    matches5("5개 일치 (1,500,000원)", 1500000,  0),
    matches5_bonus("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 0),
    matches6("6개 일치 (2,000,000,000원)", 2000000000, 0)
    ;

    // 문자열을 저장할 필드
    private String matchesN;
    private int amount, numOfMatches;

    private LottoResult(String matchesN, int amount, int numOfMatches) {
        this.matchesN = matchesN;
        this.amount = amount;
        this.numOfMatches = numOfMatches;
    }

    public String getMatchesN() {
        return matchesN;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }
}
