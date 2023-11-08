package lotto.model;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    private final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("보너스 번호가 1부터 45가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new Bonus(46, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 없는 경우 예외가 발생한다.")
    @Test
    void createLottoWithNoInput() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer nullValue = null;

        assertThatThrownBy(() -> new Bonus(nullValue, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복이면 예외가 발생한다.")
    @Test
    void compareLottoAndBonusByDuplicateNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 6;
        assertThatThrownBy(() -> new Bonus(bonus, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
