package lotto.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringToIntegerTest {

    @DisplayName("구입금액과 보너스번호 입력시 정수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName}: {0}")
    @NullSource
    @ValueSource(strings = {"1a", "1.1", "dka", "ㅏㅇ1", ""})
    void createNotNumber(String value) {
        StringToInteger converter = new StringToInteger();
        assertThatThrownBy(() -> converter.convert(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액과 보너스번호 입력시 Integer 범위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"987654321000", "10000000000000000000"})
    void createNotInteger(String value) {
        StringToInteger converter = new StringToInteger();
        assertThatThrownBy(() -> converter.convert(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}