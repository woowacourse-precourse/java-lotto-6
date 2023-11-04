package lotto.model;

import static lotto.view.exception.InputException.NUMBER_FORMAT_EXCEPTION;
import static lotto.view.exception.InputException.UNVALID_GOAL_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    @DisplayName("정상적인 값이 주어질 시 생성된다.")
    void validNumberTest() {
        // given
        String numberInput = "30";
        assertDoesNotThrow(() -> BonusNumber.from(numberInput));
    }

    @Nested
    @DisplayName("보너스 번호 예외 테스트")
    class BonusNumberExceptionTest {

        @Test
        @DisplayName("숫자가 아닌 값이면 예외가 발생한다.")
        void notNumberInputExceptionTest() {
            // given
            String numberInput = "abc";

            // when & then
            assertThatThrownBy(() -> BonusNumber.from(numberInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_FORMAT_EXCEPTION.getMessage());
        }

        @Test
        @DisplayName("로또 숫자에서 생성될 수 없는 수면 안 된다.")
        void unvalidNumberValueExceptionTest() {
            // given
            String numberInput = "100";

            // when & then
            assertThatThrownBy(() -> BonusNumber.from(numberInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(UNVALID_GOAL_NUMBER.getMessage());
        }
    }
}
