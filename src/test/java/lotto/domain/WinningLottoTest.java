package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호가 1과 45 사이일 때 WinningLotto가 성공적으로 생성된다")
    void createWinningLotto_WithValidBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("보너스 번호가 1보다 작거나 45보다 크면 예외가 발생한다")
    void validateBonusNumber_WhenNumberOutOfRange_ThrowsException() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int invalidBonusNumber1 = 0;
        assertThatThrownBy(() -> new WinningLotto(lotto, invalidBonusNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다");

        int invalidBonusNumber2 = 46;
        assertThatThrownBy(() -> new WinningLotto(lotto, invalidBonusNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다");
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다")
    void validateBonusNumber_WhenNumberIsDuplicated_ThrowsException() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int duplicatedBonusNumber = 6; // 중복된 번호

        assertThatThrownBy(() -> new WinningLotto(lotto, duplicatedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
}
