package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLottoWithBonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoWithBonusTest {
    @DisplayName("로또 번호와 보너스 번호 중복시 예외가 발생한다.")
    @Test
    void createBonusByDuplicate() {
        assertThatThrownBy(() -> new WinningLottoWithBonus(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createBonusByOutOfRange(int input) {
        assertThatThrownBy(() -> new WinningLottoWithBonus(new Lotto(List.of(1, 2, 3, 4, 5, 6)), input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}