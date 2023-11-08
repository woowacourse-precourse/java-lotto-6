package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningValidatorTest {

    @Test
    @DisplayName("당첨 번호에 숫자 이외의 값이 들어올 때 예외 테스트")
    void input_validate_when_not_number() {
        assertThatThrownBy(() -> WinningValidator.validateNonNumber("a12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 숫자 이외의 값이 들어오면 안됩니다.");
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6이 아닐 떄 예외 테스트")
    void input_validate_when_not_6() {
        assertThatThrownBy(() -> WinningValidator.validate(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 반드시 6개를 골라야 합니다. ");
    }

    @Test
    @DisplayName("당첨 번호의 숫자중 하나가 1보다 작을때 예외 테스트")
    void input_validate_when_less_than_min() {
        assertThatThrownBy(() -> WinningValidator.validate(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1 ~ 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호의 숫자중 하나가 45보다 클 때 예외 테스트")
    void input_validate_when_greater_than_max() {
        assertThatThrownBy(() -> WinningValidator.validate(List.of(46,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1 ~ 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호에 중복이 있을 때 예외 테스트")
    void input_validate_when_duplicate_exist() {
        assertThatThrownBy(() -> WinningValidator.validate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 중복 숫자가 존재합니다.");
    }
}