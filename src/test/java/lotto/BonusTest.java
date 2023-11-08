package lotto;

import static lotto.Model.Bonus.ERROR_INVALID_BONUS;
import static lotto.Model.Bonus.ERROR_NOT_BONUS_NUMBER_FORMAT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Model.Bonus;
import lotto.Model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    WinningLotto winningLotto;

    @BeforeEach
    void set() {
        winningLotto = new WinningLotto("1,2,3,4,5,6");
    }

    @DisplayName("보너스 숫자가 문자면 예외 테스트")
    @Test
    void validateNumber1() {
        assertThatThrownBy(() -> new Bonus("a", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_BONUS_NUMBER_FORMAT);
    }

    @DisplayName("보너스 숫자가 int타입을 벗어나면 예외 테스트")
    @Test
    void validateNumber2() {
        assertThatThrownBy(() -> new Bonus("10000000000000000", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_BONUS_NUMBER_FORMAT);
    }

    @DisplayName("보너스 숫자가 1~45인지 테스트")
    @Test
    void validateNumberRange() {
        assertThatThrownBy(() -> new Bonus("46", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_BONUS_NUMBER_FORMAT);
    }

    @DisplayName("보너스번호가 당첨번호에 포함되어 있으면 예외 발생하는 테스트")
    @Test
    void contain() {
        assertThatThrownBy(() -> new Bonus("5", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_BONUS);
    }
}
