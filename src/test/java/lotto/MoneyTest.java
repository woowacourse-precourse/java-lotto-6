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
}