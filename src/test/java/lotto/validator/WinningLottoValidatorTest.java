package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningLottoValidatorTest {
    @Nested
    @DisplayName("validateWinningNumber 메소드 test")
    class validateWinningNumber {
        @DisplayName("당첨 번호가 숫자와 '" + InputValidator.DELIMITER + "'만으로 이루어져 있으면 검증 성공")
        @Test
        void Winning_number_is_matched_winning_numbers_regex() {
            // given
            String input1 = "1,2,3,4,5,6";
            String input2 = "100,200,300,400,500,600";

            // when
            // then
            WinningLottoValidator.inputValidate(input1);
            WinningLottoValidator.inputValidate(input2);
        }

        @DisplayName("당첨 번호가 입력되지 않은 경우 예외 발생")
        @Test
        void Purchase_amount_is_empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> WinningLottoValidator.inputValidate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.ENTER_VALUE_MESSAGE);
        }

        @DisplayName("당첨 번호에 숫자 이외에 문자가 들어있다면 예외 발생")
        @Test
        void Winning_numbers_contain_characters_except_numbers() {
            // given
            String input = "A,1,2,3,4,5";

            // when
            // then
            assertThatThrownBy(() -> WinningLottoValidator.inputValidate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WinningLottoValidator.WRONG_INPUT_WINNING_NUMBERS_MESSAGE);
        }

        @DisplayName("당첨 번호가 구분자가 '" + InputValidator.DELIMITER + "' 가 아닐 때 예외 발생")
        @Test
        void test() {
            // given
            String input = "1.2.3.4.5.6";

            // when
            // then
            assertThatThrownBy(() -> WinningLottoValidator.inputValidate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WinningLottoValidator.WRONG_INPUT_WINNING_NUMBERS_MESSAGE);
        }
    }
}