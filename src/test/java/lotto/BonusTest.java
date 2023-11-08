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

    @DisplayName("보너스 번호가 빈칸이면 예외가 발생한다.")
    @Test
    void bonusIsEmpty() {
        assertThatThrownBy(() -> new Bonus(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void bonusIsBoundary() {
        assertThatThrownBy(() -> new Bonus("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
