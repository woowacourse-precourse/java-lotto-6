package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private static final Integer DEFAULT_COUNT = 0;

    private final Map<LottoPlace, Integer> lottoPlaces = new HashMap<>();

    public Integer getPlaceCount(LottoPlace lottoPlace) {
        return getCount(lottoPlace);
    }

    public void plusLottoPlace(LottoPlace lottoPlace) {
        Integer previousCount = getCount(lottoPlace);
        lottoPlaces.put(lottoPlace, previousCount + 1);
    }

    public Money calculateTotalRevenue() {
        return this.lottoPlaces
                .keySet()
                .stream()
                .map(this::calculateRevenue)
                .reduce(Money::sum)
                .orElse(Money.getZeroMoney());
    }

    private Money calculateRevenue(LottoPlace lottoPlace) {
        Integer count = getCount(lottoPlace);
        Money prizeAmount = lottoPlace.getPrizeAmount();
        return prizeAmount.multiply(count);
    }

    public Integer getCount(LottoPlace key) {
        return lottoPlaces.getOrDefault(key, DEFAULT_COUNT);
    }
}
