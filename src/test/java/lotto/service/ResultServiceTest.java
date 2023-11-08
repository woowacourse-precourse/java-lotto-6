package lotto.service;

import lotto.domain.Result;
import lotto.enumeration.WinningType;
import org.assertj.core.api.BigDecimalAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultServiceTest {
    ResultService resultService = new ResultService();

    @DisplayName("구매금액 대비 수익률을 계산한다.")
    @Test
    void calcProfitRate() {
        Result result = new Result();
        result.update(WinningType.FIFTH);
        int amount = 8000;

        assertThat(resultService.calcProfitRate(result, amount))
                .isEqualTo(new BigDecimal(62.5));

    }

    @DisplayName("총 당첨금을 계산한다.")
    @Test
    void getTotalPrize() {
        Result result = new Result();
        result.update(WinningType.FIFTH);

        assertThat(resultService.getTotalPrize(result))
                .isEqualTo(5000);
    }
}
