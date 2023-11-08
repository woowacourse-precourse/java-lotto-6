package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Player;
import lotto.util.ConvertInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertInputTest {
    @DisplayName("구입 금액을 두 개 이상 입력하면 예외가 발생한다.")
    @Test
    void manyValuesTest() {
        assertThatThrownBy(() -> ConvertInput.makePlayerMoneyToInt("1000,2000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void hasNotNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makePlayerMoneyToInt("1e"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
