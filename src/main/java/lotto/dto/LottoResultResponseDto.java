package lotto.dto;

import java.math.BigDecimal;
import java.util.List;

public record LottoResultResponseDto(List<Integer> prizeCount, BigDecimal profitRate) {

    public int prizeCountValue(int index) {
        return prizeCount.get(index);
    }

    public String profitRatePrint() {
        return profitRate.stripTrailingZeros()
                .toPlainString();
    }
}
