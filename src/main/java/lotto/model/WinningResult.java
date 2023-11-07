package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private static final Integer DEFAULT_COUNT = 0;

    private final Map<LottoPlace,Integer> lottoPlaces = new HashMap<>();

    public Integer getPlaceCount(LottoPlace lottoPlace) {
        return getCount(lottoPlace);
    }

    public void plusLottoPlace(LottoPlace lottoPlace) {
        Integer previousCount = getCount(lottoPlace);
        lottoPlaces.put(lottoPlace, previousCount + 1);
    }

    private Integer getCount(LottoPlace key) {
        return lottoPlaces.getOrDefault(key,DEFAULT_COUNT);
    }
}
