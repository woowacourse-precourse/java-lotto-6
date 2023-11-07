package lotto.dto;

import java.text.DecimalFormat;
import lotto.model.LottoRankResult;

public record LottoTotalReturnDTO(LottoRankResult result, int countOfLotto) {
    public String getTotalReturn() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.#");
        float totalReturn = result.getTotalReturn(countOfLotto);
        return decimalFormat.format(totalReturn);
    }
}
