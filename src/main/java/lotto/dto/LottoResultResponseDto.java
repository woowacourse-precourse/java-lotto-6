package lotto.dto;

import java.math.BigDecimal;
import java.util.List;

public record LottoResultResponseDto(List<Integer> prizeResults, BigDecimal profitRate) {
    public String toStringProfitRate() {
        return profitRate.stripTrailingZeros()
                .toPlainString();
    }
}
