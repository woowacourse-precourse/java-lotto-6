package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Domain.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void bonusIsNumber() {
        assertThatThrownBy(() -> new Bonus("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
