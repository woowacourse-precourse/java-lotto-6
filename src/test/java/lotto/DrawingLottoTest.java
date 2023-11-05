package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DrawingLottoTest {
    @DisplayName("로또 번호 범위를 넘어서는 보너스 번호가 들어오면 예외를 발생한다.")
    @Test
    void createDrawingLottoByOutOfRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 0;

        assertThatThrownBy(() -> new DrawingLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외를 발생한다.")
    @Test
    void createDrawingLottoByDuplicatedBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        assertThatThrownBy(() -> new DrawingLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
