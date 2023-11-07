package lotto.model;

import java.util.*;

import static lotto.model.LottoResultFormat.*;

public class LottoResult {
    private final HashMap<LottoResultFormat, Integer> lottoResultHashMap;

    public LottoResult(){
        this.lottoResultHashMap = new HashMap<>();
        for (LottoResultFormat lottoResultFormat : LottoResultFormat.values()){
            lottoResultHashMap.put(lottoResultFormat, 0);
        }
    }

    public void addHashMap(int numberOfMatchLotto, boolean isBonusMatch) {
        System.out.println("formatting으로 들어가는 몇개 일치?: "+numberOfMatchLotto);
        lottoResultHashMap.put(formatting(numberOfMatchLotto, isBonusMatch), lottoResultHashMap.getOrDefault(formatting(numberOfMatchLotto, isBonusMatch), 0) + 1);
        System.out.println("formatting 값(몇개 일치?): "+formatting(numberOfMatchLotto, isBonusMatch).getLottoOfMatching()+"이게 현재 몇개?: "+lottoResultHashMap.getOrDefault(formatting(numberOfMatchLotto, isBonusMatch), 0));
    }

    private static LottoResultFormat formatting(int numberOfMatchLotto, boolean isBonusMatch) {
        for (LottoResultFormat lottoResultFormat : LottoResultFormat.values()) {
            if (numberOfMatchLotto == 5 && isBonusMatch) {
                System.out.println("FIVE bonus 리턴!");
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
