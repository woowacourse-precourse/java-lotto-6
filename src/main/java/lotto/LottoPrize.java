package lotto;

public enum LottoPrize {
    MATCH_3(3, 5000),                  // 3개 일치
    MATCH_4(4, 50000),                // 4개 일치
    MATCH_5(5, 1500000),              // 5개 일치
    MATCH_5_BONUS(5, 30000000),       // 5개 일치, 보너스 볼 일치
    MATCH_6(6, 2000000000);           // 6개 일치

    private int matchingNumbers;  // 일치하는 숫자 개수
    private long prizeAmount;      // 상금 금액

    LottoPrize(int matchingNumbers, long prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }
}
