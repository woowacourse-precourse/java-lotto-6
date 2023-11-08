package lottomachine;

public class LottoResult {

    private int rank = 0;
    private int prize = 0;

    private int matchCount = 0;

    private boolean bonusMatch = false;

    public LottoResult(int matchCount, boolean bonusMatch) {
        LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, bonusMatch);
        if (lottoPrize != null) {
            this.prize = lottoPrize.getPrizeMoney();
            this.rank = lottoPrize.getRank();
            this.bonusMatch = lottoPrize.isBonusMatch();
        }
        this.matchCount = matchCount;
    }



    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
