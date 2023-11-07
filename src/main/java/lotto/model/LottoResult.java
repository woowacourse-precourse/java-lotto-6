package lotto.model;

import java.util.*;

import static lotto.model.LottoResultFormat.*;

public class LottoResult {
    private final HashMap<LottoResultFormat, Integer> lottoResultHashMap;

//    public LottoResult(HashMap<LottoResultFormat, Integer> lottoResultHashMap) {
//        this.lottoResultHashMap = lottoResultHashMap;
//    }

    public LottoResult(){
        this.lottoResultHashMap = new HashMap<>();
        for (LottoResultFormat lottoResultFormat : LottoResultFormat.values()){
            lottoResultHashMap.put(lottoResultFormat, 0);
        }
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
        return FAIL;
    }

    public Map<LottoResultFormat, Integer> getLottoResultHashMap() {
        return getSortedHashMap();
    }

    public Map<LottoResultFormat, Integer> getSortedHashMap() {
        List<Map.Entry<LottoResultFormat, Integer>> entryList = new ArrayList<>(lottoResultHashMap.entrySet());
        Collections.sort(entryList, (entry1, entry2) -> {
            int matching1 = entry1.getKey().getLottoOfMatching();
            int matching2 = entry2.getKey().getLottoOfMatching();
            return Integer.compare(matching1, matching2);
        });

        Map<LottoResultFormat, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<LottoResultFormat, Integer> entry : entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

}
