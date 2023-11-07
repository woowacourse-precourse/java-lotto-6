package lotto.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import lotto.model.rank.LottoRankResult;

public record LottoTotalReturnDTO(LottoRankResult result, int countOfLotto) {
    public String getTotalReturn() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.#");
        BigDecimal totalReturn = result.getTotalReturn(countOfLotto);
        return decimalFormat.format(totalReturn);
    }
}
