package lottomachine;

public class LottoResult {
    private int matchCount;
    private boolean bonusMatch;

    public LottoResult(int matchCount, boolean bonusMatch){
        this.bonusMatch = bonusMatch;
        this.matchCount = matchCount;
    }
}
