package lotto.io;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("입력값 검증 클래스에")
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("숫자 여부 검증 요청시")
    @Nested
    class ValidateNumeric {

        @DisplayName("숫자로 이루어진 경우 예외를 던지지 않는다.")
        @Test
        void numeric() {
            // given
            // when
            // then
            assertThatNoException().isThrownBy(() -> inputValidator.validateNumeric("1"));
        }

        @DisplayName("숫자로만 이루어지지 않은 경우 예외를 던지지 않는다.")
        @Test
        void hasNotNumeric() {
            // given
            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateNumeric("1a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨 번호 입력값 형태 검증 요청시")
    @Nested
    class validateWinningNumbers {

        @DisplayName("형식이 유효하면 예외를 던지지 않는다.")
        @Test
        void properInput() {
            // given
            // when
            // then
            assertThatNoException()
                    .isThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,6"));
        }

        @DisplayName("잘못된 형식인 경우 예외를 던진다.")
        @Test
        void invalidInput() {
            // given
            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,6,"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
