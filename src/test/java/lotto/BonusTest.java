package lotto;

import static lotto.Model.Bonus.ERROR_NOT_BONUS_NUMBER_FORMAT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Model.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    @DisplayName("보너스 숫자가 문자면 예외 테스트")
    @Test
    void validateNumber1() {
        assertThatThrownBy(() -> new Bonus("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_BONUS_NUMBER_FORMAT);
    }

    @DisplayName("보너스 숫자가 int타입을 벗어나면 예외 테스트")
    @Test
    void validateNumber2() {
        assertThatThrownBy(() -> new Bonus("10000000000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_BONUS_NUMBER_FORMAT);
    }

    @DisplayName("보너스 숫자가 1~45인지 테스트")
    @Test
    void validateNumberRange() {
        assertThatThrownBy(() -> new Bonus("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_BONUS_NUMBER_FORMAT);
    }
}
