package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("보너스 숫자가 로또 번호 중 하나와 같으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNum() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoByOutOfRangeBonusNum() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
