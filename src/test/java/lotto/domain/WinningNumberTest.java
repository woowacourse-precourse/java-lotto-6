package lotto.domain;

import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("WinningNumber 테스트")
class WinningNumberTest {

    @DisplayName("생성자 테스트")
    @Nested
    class constructor {

        @DisplayName("숫자의 범위가 1~45를 벗어나면 오류를 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 46, 100})
        void givenNumberIsOutOfLottoNumberRange(int number) {
            assertThatThrownBy(() -> new WinningNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.OUT_OF_LOTTO_RANGE_MESSAGE);
        }

    }

    @DisplayName("is 테스트")
    @Nested
    class is {

        @DisplayName("입력한 숫자가 같으면 참을 반환한다.")
        @Test
        void givenNumberIsSame() {
            assertTrue(new WinningNumber(1).is(1));
        }

        @DisplayName("입력한 숫자가 다르면 거짓을 반환한다.")
        @Test
        void givenNumberIsDifferent() {
            assertFalse(new WinningNumber(1).is(2));
        }

        @DisplayName("제시된 WinningNumber가 같으면 참을 반환한다.")
        @Test
        void givenWinningNumberIsSame() {
            assertTrue(new WinningNumber(1).is(new WinningNumber(1)));
        }

        @DisplayName("제시된 WinningNumber가 다르면 거짓을 반환한다.")
        @Test
        void givenWinningNumberIsDifferent() {
            assertFalse(new WinningNumber(1).is(new WinningNumber(2)));
        }


    }

}