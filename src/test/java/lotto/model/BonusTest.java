package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    @DisplayName("보너스 번호가 1~45 사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusByInvalidRange() {
        assertThatThrownBy(() -> new Bonus(82, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicateNumber() {
        assertThatThrownBy(() -> new Bonus(3, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
