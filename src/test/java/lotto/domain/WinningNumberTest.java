package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void validateSize() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 ~ 45 범위의 수를 넘으면 예외가 발생한다.")
    @Test
    void validateRange() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplication() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 해당 숫자가 포함되면 true, 아니면 false를 반환한다.")
    @Test
    void isContains() {
        // given
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");

        // when
        boolean isContainsFive = winningNumber.isContains(5);
        boolean isContainsTen = winningNumber.isContains(10);

        // then
        assertThat(isContainsFive).isTrue();
        assertThat(isContainsTen).isFalse();
    }
}