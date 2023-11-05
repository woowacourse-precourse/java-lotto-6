package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아니라면 예외를 발생시킨다.")
    void winningNumber_throwException() {
        /**
         * given : 5개의 당첨 번호가 담긴 문자가 주어진다.
         * when : WinningNumber 객체를 생성한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        String winningNumInput = "1,2,3,4,5";

        assertThatThrownBy(() -> new WinningNumber(winningNumInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 6개여야 합니다.");
    }
}