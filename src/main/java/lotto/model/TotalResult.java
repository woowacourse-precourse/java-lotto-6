package lotto.model;

import lotto.LottoResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TotalResult {
    private Map<LottoResult, Integer> resultCount = new HashMap<>();

    public void add(LottoResult lottoResult) {
        resultCount.put(
                lottoResult,
                resultCount.getOrDefault(lottoResult, 0) + 1
        );
    }

    public int get(LottoResult lottoResult) {
        return resultCount.getOrDefault(lottoResult, 0);
    }
}
