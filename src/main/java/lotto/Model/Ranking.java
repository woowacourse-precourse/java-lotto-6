package lotto.Model;

public enum Ranking {

    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    private int winningCount;
    private int winningAmount;
    private String message;

    Ranking(int winningCount, int winningAmount, String message) {
        this.winningCount = winningCount;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public static Ranking valueOf(int winningCount, boolean matchBonusNum) {
        if(winningCount < 3) return MISS;
        if(SECOND.matchCnt(winningCount) && matchBonusNum) return SECOND;

        for(Ranking ranking : values()) {
            if(ranking.matchCnt(winningCount) && ranking != SECOND) return ranking;
        }
        throw new IllegalArgumentException("[ERROR] 당첨 내역 조회 중 문제가 발생하였습니다.");
    }

    private boolean matchCnt(int count) {
        return this.winningCount == count;
    }

    public void outputMessage(int count) {
        if(this != MISS) System.out.println(message + count + "개");
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}