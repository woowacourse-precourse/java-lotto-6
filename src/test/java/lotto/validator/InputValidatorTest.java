package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Nested
    @DisplayName("validatePurchaseAmount 메소드 test")
    class validatePurchaseAmountTest {
        @DisplayName("구입 금액이 숫자일 경우 검증 성공")
        @Test
        void Purchase_amount_is_a_number() {
            // given
            String input1 = "1";
            String input100 = "100";
            String input1000 = "1000";

            // when
            // then
            InputValidator.validatePurchaseAmount(input1);
            InputValidator.validatePurchaseAmount(input100);
            InputValidator.validatePurchaseAmount(input1000);
        }

        @DisplayName("구입 금액이 입력되지 않은 경우 예외 발생")
        @Test
        void Purchase_amount_is_empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.ENTER_VALUE_MESSAGE);
        }

        @DisplayName("구입 금액이 숫자가 아닐 경우 예외 발생")
        @Test
        void Purchase_amount_is_not_a_number() {
            // given
            String input = "AAAA";

            // when
            // then
            assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.WRONG_INPUT_PURCHASE_AMOUNT_MESSAGE);
        }
    }

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
            InputValidator.validateWinningNumbers(input1);
            InputValidator.validateWinningNumbers(input2);
        }

        @DisplayName("당첨 번호가 입력되지 않은 경우 예외 발생")
        @Test
        void Purchase_amount_is_empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
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
            assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.WRONG_INPUT_WINNING_NUMBERS_MESSAGE);
        }

        @DisplayName("당첨 번호가 구분자가 '" + InputValidator.DELIMITER + "' 가 아닐 때 예외 발생")
        @Test
        void test() {
            // given
            String input = "1.2.3.4.5.6";

            // when
            // then
            assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.WRONG_INPUT_WINNING_NUMBERS_MESSAGE);
        }
    }

    @Nested
    @DisplayName("validateBonusNumber 메소드 test")
    class ValidateBonusNumber {
        @DisplayName("보너스 번호로 숫자가 들어오면 검증 통과")
        @Test
        void Bonus_number_consists_of_numbers() {
            // given
            String input1 = "1";
            String input100 = "100";
            String input10000 = "10000";

            // when
            // then
            InputValidator.validateBonusNumber(input1);
            InputValidator.validateBonusNumber(input100);
            InputValidator.validateBonusNumber(input10000);
        }

        @DisplayName("보너스 숫자가 입력되지 않은 경우 예외 발생")
        @Test
        void Purchase_amount_is_empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.ENTER_VALUE_MESSAGE);
        }

        @DisplayName("보너스 번호로 숫자 외에 입력이 들어오면 예외 발생")
        @Test
        void Bonus_numbers_contain_characters_except_numbers() {
            // given
            String input = "A";

            // when
            // then
            assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.WRONG_INPUT_BONUS_NUMBER_MESSAGE);
        }
    }
}