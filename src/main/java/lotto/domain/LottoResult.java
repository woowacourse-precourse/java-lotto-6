package lotto.domain;

public enum LottoResult {
    MATCH_3(3, 5000, "3개 일치 (5,000원) - "),
    MATCH_4(4, 50000, "4개 일치 (50,000원) - "),
    MATCH_5(5, 1500000, "5개 일치 (1,500,000원) - "),
    MATCH_5_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_6(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchedNumbers;
    private final int prize;
    private final String matchMessage;

    LottoResult(int matchedNumbers, int prize, String matchMessage) {
        this.matchedNumbers = matchedNumbers;
        this.prize = prize;
        this.matchMessage = matchMessage;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public int getPrize() {
        return prize;
    }

    public String getResultDescription(int count) {
        return matchMessage + count + "개";
    }

    public boolean isBonusMatch(boolean bonusMatch) {
        return this == MATCH_5 && bonusMatch;
    }
}

