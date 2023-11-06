package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberCandidateStringTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "90 0", "-1a00"})
    @DisplayName("숫자가 아닌 입력시 예외")
    public void createByNonNumeric(String money) {
        assertThatThrownBy(() -> new NumberCandidateString(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈값 입력시 예외")
    public void createByEmptyString() {
        assertThatThrownBy(() -> new NumberCandidateString("")).isInstanceOf(IllegalArgumentException.class);
    }

}
