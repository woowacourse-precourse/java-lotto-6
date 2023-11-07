package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.config.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[단위 테스트] 수익률")
class ProfitTest {

    @DisplayName("수익률 0%일 때 정확한 결과를 계산한다.")
    @Test
    void get_profit_rate_of_zero() {
        // given
        Money money = new Money(5000);
        LottoResult lottoResult = new LottoResult(Map.of(Rank.NO_RANK, 0L));

        // when
        Profit profit = new Profit(money, lottoResult);
        double profitRate = profit.getProfitRate();
        double actual = Double.parseDouble(String.format("%.1f", profitRate));

        // then
        assertThat(actual).isEqualTo(0.0);
    }

    @DisplayName("수익률 100%일 때 정확한 결과를 계산한다.")
    @Test
    void get_profit_rate_of_100() {
        // given
        Money money = new Money(5000);
        LottoResult lottoResult = new LottoResult(Map.of(Rank.FIFTH, 1L));

        // when
        Profit profit = new Profit(money, lottoResult);
        double profitRate = profit.getProfitRate();
        double actual = Double.parseDouble(String.format("%.1f", profitRate));

        // then
        assertThat(actual).isEqualTo(100.0);
    }

    @DisplayName("수익률은 소수점 둘째 자리에서 반올림한다.")
    @Test
    void get_profit_rate_of_rounding() {
        // given
        Money money = new Money(9000);
        LottoResult lottoResult = new LottoResult(Map.of(Rank.FIFTH, 1L));

        // when
        Profit profit = new Profit(money, lottoResult);
        double profitRate = profit.getProfitRate();
        double actual = Double.parseDouble(String.format("%.1f", profitRate));

        // then
        assertThat(actual).isEqualTo(55.6);
    }
}
