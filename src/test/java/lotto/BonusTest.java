package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {

    @DisplayName("보너스 번호는 당첨 번호와 달라야 합니다.")
    @Test
    void validateBonus() {
        assertThatThrownBy(() -> new Bonus(1, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 1~45 사이의 숫자여야 합니다.")
    @Test
    void InRangeBonus() {
        assertThatThrownBy(() -> new Bonus(1, new Lotto(List.of(1, 2, 3, 4, 5, 66))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
