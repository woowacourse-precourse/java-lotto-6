package lotto.model;

public enum LottoResult {
    FIFTH(3, 0,"3개 일치", 5000),
    FOURTH(4, 0, "4개 일치", 50000),
    THIRD(5, 0, "5개 일치", 1500000),
    SECOND(5, 1, "5개 일치, 보너스 볼 일치", 30000000),
    FIRST(6, 0, "6개 일치", 2000000000);

    private final int winningCnt;
    private final int bonusCnt;
    private final String rule;
    private final int prize;

    LottoResult(int winningCnt, int bonusCnt, String rule, int prize) {
        this.winningCnt = winningCnt;
        this.bonusCnt = bonusCnt;
        this.rule = rule;
        this.prize = prize;
    }
}
