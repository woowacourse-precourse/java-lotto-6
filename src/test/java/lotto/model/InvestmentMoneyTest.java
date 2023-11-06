package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InvestmentMoneyTest {

    @Test
    void 투자_금액은_음수_값을_가질수_없다() {
        int investmentMoney = -1;

        assertThatThrownBy(() -> InvestmentMoney.from(investmentMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 투자_금액은_0원을_가질수_없다() {
        int investmentMoney = 0;

        assertThatThrownBy(() -> InvestmentMoney.from(investmentMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 투자_금액은_최대한도를_초과할수_없다() {
        int investmentMoney = 100_001;

        assertThatThrownBy(() -> InvestmentMoney.from(investmentMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 100_000})
    void 투자_금액은_로또가격의_배수만큼_최소_금액과_최대한도_사이의_값을_가질수_있다(int investmentMoney) {
        assertDoesNotThrow(
                () -> InvestmentMoney.from(investmentMoney)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 1001})
    void 투자_금액은_로또_가격의_배수가_아니면_안된다(int investmentMoney) {
        assertThatThrownBy(() -> InvestmentMoney.from(investmentMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 100000})
    void 투자_금액은_로또_가격의_배수여야_한다(int investmentMoney) {
        assertDoesNotThrow(
                () -> InvestmentMoney.from(investmentMoney)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
    void 로또_가격에_따른_로또_구입_개수를_계산할수_있다(int money, int expectedLottoCount) {
        InvestmentMoney investmentMoney = InvestmentMoney.from(money);

        PurchasableLottoCount actualCount = investmentMoney.calculatePurchasableLottoCount(LottoPrice.STANDARD_PRICE);

        PurchasableLottoCount expectedCount = PurchasableLottoCount.from(expectedLottoCount);
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @MethodSource("calculateTotalProfitRateTestCases")
    void 총_상금금액에_따른_수익률을_계산할수_있다(int money, long winningMoney, double expectedProfitRate) {
        InvestmentMoney investmentMoney = InvestmentMoney.from(money);
        TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(winningMoney);

        TotalProfitRate actualProfitRate = investmentMoney.calculateTotalProfitRate(totalPrizeAmount);

        TotalProfitRate expectedProfitRateObject = TotalProfitRate.from(expectedProfitRate);
        assertThat(actualProfitRate).isEqualTo(expectedProfitRateObject);
    }

    @Test
    void 투자금액의_값이_서로_같으면_같은_객체이다() {
        InvestmentMoney actualInvestmentMoney = InvestmentMoney.from(1000);
        InvestmentMoney expectedInvestmentMoney = InvestmentMoney.from(1000);

        assertThat(actualInvestmentMoney).isEqualTo(expectedInvestmentMoney);
    }

    @Test
    void 투자금액의_값이_서로_다르면_다른_객체이다() {
        InvestmentMoney actualInvestmentMoney = InvestmentMoney.from(1000);
        InvestmentMoney expectedInvestmentMoney = InvestmentMoney.from(2000);

        assertThat(actualInvestmentMoney).isNotEqualTo(expectedInvestmentMoney);
    }

    @Test
    void 투자금액의_값이_같으면_서로_같은_해시코드를_가진다() {
        InvestmentMoney actualInvestmentMoney = InvestmentMoney.from(1000);
        InvestmentMoney expectedInvestmentMoney = InvestmentMoney.from(1000);

        assertThat(actualInvestmentMoney).hasSameHashCodeAs(expectedInvestmentMoney);
    }

    private static Stream<Arguments> calculateTotalProfitRateTestCases() {
        return Stream.of(
                Arguments.of(1000, 0L, 0.0),
                Arguments.of(1000, 5000L, 500.0),
                Arguments.of(5000, 5000L, 100.0),
                Arguments.of(1000, 50_000L, 5000.0),
                Arguments.of(1000, 1_500_000L, 150000.0),
                Arguments.of(18000, 1_500_000L, 8333.333333333332)
        );
    }
}
