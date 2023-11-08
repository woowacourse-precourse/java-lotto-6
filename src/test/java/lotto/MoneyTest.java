package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @CsvSource({"한글", "English", ">D><<"})
    @ParameterizedTest
    public void 구매_금액은_숫자만_가능(String amount) {
        assertThatThrownBy(() -> new Money(amount)).isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource({"1100", "10", "13040", "11111"})
    @ParameterizedTest
    public void 구매_금액은_올바른_단위만_가능(String amount) {
        assertThatThrownBy(() -> new Money(amount)).isInstanceOf(IllegalArgumentException.class);
    }
}