package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @DisplayName("총 수익과 구매금액을 통해 수익률을 반환해주는 기능.")
    @Test
    void 수익률_반환() {
        //given
        LottoService lottoService = new LottoService();
        long totalProfit = 5000;
        long buyCash = 8000;
        double expected = 62.5;

        //when
        double result = lottoService.getTotalProfitRate(totalProfit, buyCash);

        //then
        assertThat(result).isEqualTo(expected);
    }
}