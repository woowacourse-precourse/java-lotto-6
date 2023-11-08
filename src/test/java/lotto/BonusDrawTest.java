package lotto;

import domain.BonusDraw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusDrawTest {
    @Test
    @DisplayName("숫자가 아닌것을 입력하면 예외발생")
    public void numberFormatException() {
        BonusDraw bonusDraw = new BonusDraw();
        assertThatThrownBy(() -> bonusDraw.bonusNumber("숫자가 아님")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("생성된 로또번호와 중복되는 보너스 번호가 있으면 예외발생")
    public void duplicatedTest() {
        BonusDraw bonusDraw = new BonusDraw();
        assertThatThrownBy(() -> bonusDraw.bonusDraw(Arrays.asList(1, 2, 3, 4, 5, 6), "6")).
                isInstanceOf(IllegalArgumentException.class).hasMessageContaining("보너스 번호는");
    }
}
