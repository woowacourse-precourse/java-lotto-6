package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnigLottoTest {
    @DisplayName("당첨 번호와 보너스 번호가 중복되지 않으면 객체를 생성한다.")
    @Test
    void createWinnigLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        new WinningLotto(lotto, 7);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinnigLotto_Duplicated_BonusNumber_Exception() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 비교하여 맞은 갯수를 반환한다.")
    @Test
    void matchCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(lotto, 8);
        assertEquals(5, winningLotto.getMatchCount(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }

    @DisplayName("Lotto 안에 보너스 번호가 있는지 확인한다.")
    @Test
    void hasBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(lotto, 8);
        assertTrue(winningLotto.isMatchBonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 8))));
    }
}
