package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    @Test
    @DisplayName("보너스 번호가 1보다 작은 번호다")
    void createBonusByLessThan1() {
        assertThatThrownBy(() -> new Bonus(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_WRONG_RANGE_ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("보너스 번호가 45보다 큰 번호다")
    void createBonusByGreaterThan45() {
        assertThatThrownBy(() -> new Bonus(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_WRONG_RANGE_ERROR_MESSAGE.get());
    }
}
