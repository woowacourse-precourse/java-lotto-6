package lotto.dto;

import lotto.model.LottoRankResult;

public record LottoTotalReturnDTO(LottoRankResult result, int countOfLotto) {
    public float getTotalReturn() {
        return result.getTotalReturn(countOfLotto);
    }
}
