package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @DisplayName("money가 1000 미만의 값 이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-9000"})
    void validateRangeTest(long input) {
        // when, then
        assertThatThrownBy(() -> new Money(input))
                .hasMessage("[ERROR] 1000 이상의 숫자만 입력 가능합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("money가 1000 으로 나누어 떨어지지 않을 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1004", "1400400", "33030"})
    void validateDivideTest(long input) {
        // when, then
        assertThatThrownBy(() -> new Money(input))
                .hasMessage("[ERROR] 1000원 단위로만 구매가 가능합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나눈 값을 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "3000, 3",
            "330000, 330",
            "555550000, 555550"
    })
    void getDividedBy1000Test(long input, int expected) {
        // given
        Money money = new Money(input);

        // when
        int result = money.getDividedBy1000Test();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
