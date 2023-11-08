package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinNumberByOverSize() {
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1보다 작은 숫자가 들어가면 예외가 발생한다.")
    void createWinNumberWithValueSmallerThan1() throws Exception {
        assertThatThrownBy(() -> new WinNumber("0,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("45보다 큰 숫자가 들어가면 예외가 발생한다.")
    void createWinNumberWithValueBiggerThan45() throws Exception {
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1과 45사이의 중복되지 않은 6개의 숫자가 들어가면 예외가 발생하지 않는다")
    void createWinNumberWithNoException() throws Exception {
        assertThatNoException().isThrownBy(() -> new WinNumber("1,2,3,4,5,6"));
    }
}