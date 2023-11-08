package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @DisplayName("당첨 번호와 중복된 숫자가 있으면 예외를 발생한다.")
    @Test
    void createBonusByDuplicateOfWinningNumber() {
        assertThatThrownBy(() -> new BonusNumber(1, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createBonusByNumberLessThanOne() {
        assertThatThrownBy(() -> new BonusNumber(0, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createBonusByNumberGreaterThanFortyFive() {
        assertThatThrownBy(() -> new BonusNumber(47, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
