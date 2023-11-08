package lotto.utils;

import lotto.view.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UtilTest {

    @Test
    @DisplayName("유효한 입력에 대해 정수 목록을 반환한다")
    void parseNumbers_ReturnsListOfIntegers_WhenInputIsValid() {
        String validInput = "1, 2, 3, 4, 5, 6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> parsedNumbers = Util.parseNumbers(validInput);

        assertThat(parsedNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    @DisplayName("입력 형식이 유효하지 않을 때 예외를 던진다")
    void parseNumbers_ThrowsException_WhenInputIsInvalidFormat() {
        String invalidInput = "1,2; 3; 4- 5: 6";

        assertThatThrownBy(() -> Util.parseNumbers(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_FORMAT_ERROR.getMessage());
    }

    @Test
    @DisplayName("입력에 정수가 아닌 값이 포함되어 있을 때 예외를 던진다")
    void parseNumbers_ThrowsException_WhenInputContainsNonInteger() {
        String invalidInput = "1, 2, three, 4, 5, 6";

        assertThatThrownBy(() -> Util.parseNumbers(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_FORMAT_ERROR.getMessage());
    }
}
