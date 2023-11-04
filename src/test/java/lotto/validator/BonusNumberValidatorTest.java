package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
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
            BonusNumberValidator.inputValidate(input1);
            BonusNumberValidator.inputValidate(input100);
            BonusNumberValidator.inputValidate(input10000);
        }

        @DisplayName("보너스 숫자가 입력되지 않은 경우 예외 발생")
        @Test
        void Purchase_amount_is_empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> BonusNumberValidator.inputValidate(input))
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
            assertThatThrownBy(() -> BonusNumberValidator.inputValidate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.INVALID_INPUT_CHARACTER);
        }
    }
}