package lotto;

import java.text.DecimalFormat;

public enum LottoMatchResult {
    UNMATCHED("0개 일치", 0, 0),
    MATCHED_3("3개 일치", 1, 5000),
    MATCHED_4("4개 일치", 2, 50000),
    MATCHED_5("5개 일치", 3, 1500000),
    MATCHED_5_WITH_BONUS("5개 일치, 보너스 볼 일치", 4, 30000000),
    MATCHED_6("6개 일치", 5, 2000000000);

    private final String name;
    private final int index;
    private final int reward;

    LottoMatchResult(String name, int index, int reward) {
        this.name = name;
        this.index = index;
        this.reward = reward;
    }

    public static LottoMatchResult fromMatchedCount(int matched, boolean hasBonus) {
        if (0 <= matched && matched < 3)
            return UNMATCHED;
        if (matched == 3)
            return MATCHED_3;
        if (matched == 4)
            return MATCHED_4;
        if (matched == 5 && hasBonus)
            return MATCHED_5_WITH_BONUS;
        if (matched == 5)
            return MATCHED_5;
        if (matched == 6)
            return MATCHED_6;
        throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }
    public int getIndex() {
        return index;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public String toString() {
        DecimalFormat priceFormat = new DecimalFormat("###,###");
        return name + " (" + priceFormat.format(reward) + ",원)";
    }
}