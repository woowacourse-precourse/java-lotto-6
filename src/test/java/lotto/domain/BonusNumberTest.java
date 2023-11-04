package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
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
            BonusNumber bonusNumber1 = new BonusNumber(number1);
            BonusNumber bonusNumber2 = new BonusNumber(number2);
            BonusNumber bonusNumber3 = new BonusNumber(number3);
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
            assertThatThrownBy(() -> new BonusNumber(number1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BonusNumberValidator.INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
            assertThatThrownBy(() -> new BonusNumber(number2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BonusNumberValidator.INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
            assertThatThrownBy(() -> new BonusNumber(number3)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BonusNumberValidator.INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }
}