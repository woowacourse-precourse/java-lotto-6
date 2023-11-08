package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @CsvSource({"1100", "13040", "11111"})
    @ParameterizedTest
    public void 구매_금액은_올바른_단위만_가능(String amount) {
        assertThatThrownBy(() -> new Money(Integer.parseInt(amount))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @CsvSource({"-10", "0", "11", "999"})
    @ParameterizedTest
    public void 구매_금액은_최소_1000원_이상(String amount) {
        assertThatThrownBy(() -> new Money(Integer.parseInt(amount))).isInstanceOf(
                IllegalArgumentException.class);
    }
}