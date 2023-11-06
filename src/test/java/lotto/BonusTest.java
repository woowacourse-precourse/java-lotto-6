package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Model.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    @DisplayName("보너스 숫자가 문자면 예외 테스트")
    @Test
    void isNumber1() {
        assertThatThrownBy(() -> new Bonus("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1~45사이의 숫자로만 입력해야 합니다.");
    }

    @DisplayName("보너스 숫자가 int타입을 벗어나면 예외 테스트")
    @Test
    void isNumber2() {
        assertThatThrownBy(() -> new Bonus("10000000000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1~45사이의 숫자로만 입력해야 합니다.");
    }

    @DisplayName("보너스 숫자가 1~45인지 테스트")
    @Test
    void isCorrectRange() {
        assertThatThrownBy(() -> new Bonus("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다.");
    }
}
