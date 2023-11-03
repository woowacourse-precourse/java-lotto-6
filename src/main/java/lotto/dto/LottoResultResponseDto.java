package lotto.dto;

import java.math.BigDecimal;
import java.util.List;

public record LottoResultResponseDto(List<Integer> prizeReuslts, BigDecimal profitRate) {

    public int getPrizeResultCount(int index) {
        return prizeReuslts.get(index);
    }

    public String toStringProfitRate() {
        return profitRate.stripTrailingZeros()
                .toPlainString();
    }
}
