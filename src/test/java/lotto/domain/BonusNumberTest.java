package lotto.domain;

import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 번호에 정수가 아닌 값 입력 시, 예외처리하는지")
    @ParameterizedTest
    @ValueSource(strings = {"12a", "a3", "aa", "@"})
    void isNumericTest(String input) {
        // given & when & then
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("보너스 번호에 1부터 45 사이의 값 입력 시, 예외처리하는지")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "300"})
    void isCorrectNumberRangeTest(String input) {
        // given & when & then
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(InvalidInputException.class);
    }
}