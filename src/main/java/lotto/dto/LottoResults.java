package lotto.dto;

import java.util.List;

public record LottoResults(List<LottoResult> lottoResults, float returnRate) {
    public static LottoResults of(List<LottoResult> lottoResults, float returnRate) {
        return new LottoResults(lottoResults, returnRate);
    }
}
