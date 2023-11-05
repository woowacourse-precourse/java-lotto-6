package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("당첨번호 validation 확인")
class WinningNumberValidatorTest {

    @Nested
    @DisplayName("당첨번호 포맷 확인")
    class WinningNumberFormatTest {
        @DisplayName("정규표현식을 사용한 validation 정상동작")
        @Test
        void validate_using_regexp() {
            // given
            String input = "6,21,24,36,44,45";

            assertThatNoException().isThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            );
        }

        @DisplayName("정규표현식을 사용한 validation 숫자 범위 벗어난 입력(0)일땐 예외")
        @Test
        void validation_invalid_range_number_0() {
            // given
            String input = "0,1,2,3,4,5";

            assertThatThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정규표현식을 사용한 validation 숫자 범위 벗어난 입력(46)일땐 예외")
        @Test
        void validation_invalid_range_number_46() {
            // given
            String input = "1,2,3,4,5,46";

            assertThatThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정규표현식을 사용한 validation 숫자 개수 6개 미만이면 예외")
        @Test
        void validation_invalid_size_less() {
            // given
            String input = "1,2,3,4,5";

            assertThatThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정규표현식을 사용한 validation 숫자 개수 6개 초과이면 예외")
        @Test
        void validation_invalid_size_greater() {
            // given
            String input = "1,2,3,4,5,6,7";

            assertThatThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정규표현식을 사용한 validation 콤마가 중복이면 예외")
        @Test
        void validation_invalid_format_duplicate_comma() {
            // given
            String input = "1,2,3,,4,5,6";

            assertThatThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정규표현식을 사용한 validation 맨 처음 콤마이면 예외")
        @Test
        void validation_invalid_format_at_first_comma() {
            // given
            String input = ",1,2,3,4,5,6";

            assertThatThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정규표현식을 사용한 validation 맨 마지막 콤마이면 예외")
        @Test
        void validation_invalid_format_at_last_comma() {
            // given
            String input = "1,2,3,4,5,6,";

            assertThatThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정규표현식을 사용한 validation 숫자 아닌 문자 입력시 예외")
        @Test
        void validation_invalid_character() {
            // given
            String input = "1,2,3,4,5,a";

            assertThatThrownBy(
                    () -> WinningNumberValidator.validateFormat(input)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("당첨번호 중복 확인")
    class WinningNumberDuplicateTest {
        @DisplayName("당첨번호 중복 없는 입력은 정상 통과")
        @Test
        void validate_non_duplicated_input() {
            // given
            List<String> input = List.of("6", "21", "24", "36", "44", "45");

            assertThatNoException().isThrownBy(
                    () -> WinningNumberValidator.validateDuplicate(input)
            );
        }

        @DisplayName("당첨번호 중복시 예외")
        @Test
        void validate_duplicated_input() {
            // given
            List<String> input = List.of("6", "6", "24", "36", "44", "45");

            assertThatThrownBy(() -> WinningNumberValidator.validateDuplicate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}