package lotto.model;

import java.util.List;

public enum LottoResult {
    FIFTH(3, 0,"3개 일치", 5000),
    FOURTH(4, 0, "4개 일치", 50000),
    THIRD(5, 0, "5개 일치", 1500000),
    SECOND(5, 1, "5개 일치, 보너스 볼 일치", 30000000),
    FIRST(6, 0, "6개 일치", 2000000000);

    private final int winningCnt;
    private final int bonusCnt;
    private final String rule;
    private final long prize;

    LottoResult(int winningCnt, int bonusCnt, String rule, int prize) {
        this.winningCnt = winningCnt;
        this.bonusCnt = bonusCnt;
        this.rule = rule;
        this.prize = prize;
    }

    public String getRule() {
        return rule;
    }

    public long getPrize() {
        return prize;
    }

    public static LottoResult compareLottoNums(List<Integer> userLottoNums, WinningLotto winningLotto) {
        int equalLottoCnt = 0;
        int equalBonusCnt = 0;
        for (int userLottoNum : userLottoNums) {
            if (winningLotto.getLotto().getNumbers().contains(userLottoNum)) {
                equalLottoCnt++;
            }
        }
        if (userLottoNums.contains(winningLotto.getBonus())) {
            equalBonusCnt++;
        }
        return findCorrectLottoResult(equalLottoCnt, equalBonusCnt);
    }

    private static LottoResult findCorrectLottoResult(int equalLottoCnt, int equalBonusCnt) {
        LottoResult findResult = null;
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.winningCnt == equalLottoCnt && lottoResult.bonusCnt == equalBonusCnt) {
                findResult = lottoResult;
            }
        }
        return findResult;
    }
}
