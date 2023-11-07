package lotto.domain;

import static lotto.enums.LottoCalculateNums.BONUS;
import static lotto.enums.LottoCalculateNums.BONUS_CONDITION;

public class LottoResult {
    int matchedCnt;
    boolean isBonus;

    public LottoResult(int matchedCnt, boolean isBonus) {
        this.matchedCnt = matchedCnt;
        this.isBonus = isBonus;
    }

    public String getMatchedCntToString() {
        if(isBonus && matchedCnt==BONUS_CONDITION){
            return Integer.toString(matchedCnt) + BONUS;
        }
        return Integer.toString(matchedCnt);
    }

    public int getMatchedCnt() {
        return matchedCnt;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
