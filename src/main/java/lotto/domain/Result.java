package lotto.domain;

import lotto.enums.LottoEnum;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<LottoEnum, Integer> result = new HashMap<>();


    public void resultCount(LottoEnum lottoEnum) {
        result.put(lottoEnum, result.getOrDefault(lottoEnum, 0) + 1);
    }

    public int getCount(LottoEnum lottoEnum) {
        return result.getOrDefault(lottoEnum, 0);
    }

    public int getTotal() {
        int total = 0;
        LottoEnum[] values = LottoEnum.values();
        for (LottoEnum value : values) {
            total += result.getOrDefault(value,0) * value.getReward();
        }
        return total;
    }
}
