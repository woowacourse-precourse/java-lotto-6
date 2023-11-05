package lotto.domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lotto;
import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BonusNumberDtoTest {
    @Nested
    @DisplayName("validateBonusNumber 메소드 test")
    class ValidateBonusNumber {
        @DisplayName("번호가 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER + " 범위에 있으면 검증 통과")
        @Test
        void Numbers_in_range_lotto_range() {
            // given
            int number1 = 1;
            int number2 = 25;
            int number3 = 45;

            // when
            // then
            BonusNumberDto bonusNumber1 = new BonusNumberDto(number1);
            BonusNumberDto bonusNumber2 = new BonusNumberDto(number2);
            BonusNumberDto bonusNumber3 = new BonusNumberDto(number3);
        }

        @DisplayName("번호가 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER + " 범위를 벗어나면 예외 발생")
        @Test
        void Numbers_out_of_range_lotto_range() {
            // given
            int number1 = -10;
            int number2 = 0;
            int number3 = 46;

            // when
            // then
            assertThatThrownBy(() -> new BonusNumberDto(number1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BonusNumberValidator.INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
            assertThatThrownBy(() -> new BonusNumberDto(number2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BonusNumberValidator.INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
            assertThatThrownBy(() -> new BonusNumberDto(number3)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BonusNumberValidator.INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }
}