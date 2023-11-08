package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberExceptionTest {
    private final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("보너스 숫자로 숫자가 아닌 다른 것이 들어온 경우 예외 처리")
    void isNumberTest() {
        String input = "a";
        assertThatThrownBy(() -> new BonusNumberException(input, list)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자로 들어온 것이 1개가 아닐 경우")
    void isNumberOnlyOneTest() {
        String input = "1,2";
        assertThatThrownBy(() -> new BonusNumberException(input, list)).isInstanceOf(
                IllegalArgumentException.class
        );
    }

    @Test
    @DisplayName("보너스 숫자로 들어온 것이 1 미만 45 초과일 경우")
    void isRightRangeTest() {
        String input = "0";
        assertThatThrownBy(() -> new BonusNumberException(input, list)).isInstanceOf(
                IllegalArgumentException.class
        );
    }

    @Test
    @DisplayName("보너스 숫자로 들어온 것이 공백일 경우")
    void isBlankTest() {
        String input = " ";
        assertThatThrownBy(() -> new BonusNumberException(input, list)).isInstanceOf(
                IllegalArgumentException.class
        );
    }

    @Test
    @DisplayName("보너스 숫자로 들어온 것이 당첨 숫자와 중복일 경우")
    void isDuplicateWithWinnerNumTest() {
        String bonusNum = "3";
        assertThatThrownBy(() -> new BonusNumberException(bonusNum, list)).isInstanceOf(
                IllegalArgumentException.class
        );
    }
}