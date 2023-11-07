package lotto.model;

import java.util.HashMap;

import static lotto.model.LottoResultFormat.*;

public class LottoResult {
    private final HashMap<LottoResultFormat, Integer> lottoResultHashMap;

//    public LottoResult(HashMap<LottoResultFormat, Integer> lottoResultHashMap) {
//        this.lottoResultHashMap = lottoResultHashMap;
//    }

    public LottoResult(){
        this.lottoResultHashMap = new HashMap<>();
    }

    public void addHashMap(int numberOfMatchLotto, boolean isBonusMatch) {
        lottoResultHashMap.put(formatting(numberOfMatchLotto, isBonusMatch), lottoResultHashMap.getOrDefault(formatting(numberOfMatchLotto, isBonusMatch), 0) + 1);
    }

    private static LottoResultFormat formatting(int numberOfMatchLotto, boolean isBonusMatch) {
        for (LottoResultFormat lottoResultFormat : LottoResultFormat.values()) {
            if (numberOfMatchLotto == 5 && isBonusMatch == true) {
                return FIVE_BONUS;
            }
            if (lottoResultFormat.getLottoOfMatching() == numberOfMatchLotto) {
                return lottoResultFormat;
            }
        }
        return ERROR;
    }

    public HashMap<LottoResultFormat, Integer> getLottoResultHashMap() {
        return lottoResultHashMap;
    }

}
