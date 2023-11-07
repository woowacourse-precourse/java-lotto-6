package lotto;

public enum LottoWin {
    MATCHED_3(3, 0),
    MATCHED_4(4, 0),
    MATCHED_5(5, 0),
    MATCHED_6(6, 0),
    MATCHED_5_WITH_BONUS(7, 0);

    private int matchValue;
    private int totalMatchCount;

    LottoWin(int matchValue, int totalMatchCount) {
        this.matchValue = matchValue;
        this.totalMatchCount = totalMatchCount;
    }

    public int getMatchValue(){
        return matchValue;
    }
    public int getCount() {
        return totalMatchCount;
    }

    public void increaseCount() {
        totalMatchCount++;
    }

}
