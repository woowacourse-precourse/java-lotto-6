package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class TotalProfitRateTest {
    
    @Test
    void 총_수익률은_음수값을_가질_수_없다() {
        assertThatThrownBy(() -> TotalProfitRate.from(-1.0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 총_수익률은_0_이상이어야_한다() {
        assertDoesNotThrow(
                () -> TotalProfitRate.from(0.0)
        );
    }

    @Test
    void 총_수익률이_같다면_서로_같은_객체이다() {
        TotalProfitRate totalProfitRate = TotalProfitRate.from(5.0);
        TotalProfitRate anotherTotalProfitRate = TotalProfitRate.from(5.0);

        assertThat(totalProfitRate).isEqualTo(anotherTotalProfitRate);
    }

    @Test
    void 총_수익률이_다르다면_서로_다른_객체이다() {
        TotalProfitRate totalProfitRate = TotalProfitRate.from(5.0);
        TotalProfitRate anotherTotalProfitRate = TotalProfitRate.from(10.0);

        assertThat(totalProfitRate).isNotEqualTo(anotherTotalProfitRate);
    }

    @Test
    void 총_수익률이_같다면_서로_같은_해시코드를_가진다() {
        TotalProfitRate totalProfitRate = TotalProfitRate.from(5.0);
        TotalProfitRate anotherTotalProfitRate = TotalProfitRate.from(5.0);

        assertThat(totalProfitRate).hasSameHashCodeAs(anotherTotalProfitRate);
    }
}
