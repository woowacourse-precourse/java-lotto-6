package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("보너스 로또 번호 1보다 작을 경우 예외 발생")
    @Test
    void validateBonusLotto_isRightLottoRange1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusLotto = 0;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호 45보다 클 경우 예외 발생")
    @Test
    void validateBonusLotto_isRightLottoRange2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusLotto = 66;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호가 로또 번호와 중복되면 예외 발생")
    @Test
    void validateBonusLotto_isDuplicateWinningLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusLotto = 6;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
