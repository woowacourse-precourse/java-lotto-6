package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class TotalPrizeAmountTest {

    @Test
    void 총_당첨금은_음수값을_가질_수_없다() {
        assertThatThrownBy(() -> TotalPrizeAmount.from(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 총_당첨금은_0원_이상이어야_한다() {
        assertDoesNotThrow(
                () -> TotalPrizeAmount.from(0)
        );
    }

    @Test
    void 총_당첨금을_구매금액으로_나누면_수익률을_구할_수_있다() {
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(5_000);
        int money = 1000;

        BigDecimal actualReturnOnInvestmentRatio = totalPrizeAmount.calculatePrizeToInvestmentRatio(money);

        BigDecimal expectedReturnOnInvestmentRatio = BigDecimal.valueOf(5);
        assertThat(actualReturnOnInvestmentRatio).isEqualTo(expectedReturnOnInvestmentRatio);
    }

    @Test
    void 총_당첨금이_같다면_서로_같은_객체이다() {
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(5_000);
        TotalPrizeAmount anotherTotalPrizeAmount = TotalPrizeAmount.from(5_000);

        assertThat(totalPrizeAmount).isEqualTo(anotherTotalPrizeAmount);
    }

    @Test
    void 총_당첨금이_다르다면_서로_다른_객체이다() {
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(5_000);
        TotalPrizeAmount anotherTotalPrizeAmount = TotalPrizeAmount.from(10_000);

        assertThat(totalPrizeAmount).isNotEqualTo(anotherTotalPrizeAmount);
    }

    @Test
    void 총_당첨금이_같다면_서로_같은_해시코드를_가진다() {
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(5_000);
        TotalPrizeAmount anotherTotalPrizeAmount = TotalPrizeAmount.from(5_000);

        assertThat(totalPrizeAmount).hasSameHashCodeAs(anotherTotalPrizeAmount);
    }
}
