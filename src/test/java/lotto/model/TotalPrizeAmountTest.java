package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("provideTotalPrizeAndInvestmentForROI")
    void 총_당첨금을_구매금액으로_나누면_수익률을_구할_수_있다(long totalPrize, int investment,
                                        BigDecimal expectedReturnOnInvestmentRatio) {
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(totalPrize);

        BigDecimal actualReturnOnInvestmentRatio = totalPrizeAmount.calculatePrizeToInvestmentRatio(investment);

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

    private static Stream<Arguments> provideTotalPrizeAndInvestmentForROI() {
        return Stream.of(
                Arguments.of(5_000L, 1_000, BigDecimal.valueOf(5)),
                Arguments.of(1_000L, 1_000, BigDecimal.valueOf(1)),
                Arguments.of(50L, 100, BigDecimal.valueOf(0.5)),
                Arguments.of(0L, 1_000, BigDecimal.valueOf(0))
        );
    }
}
