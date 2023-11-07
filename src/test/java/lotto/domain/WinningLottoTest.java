package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    Lotto lotto;
    @BeforeEach
    void setUpLotto() {
         lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
    @DisplayName("당첨 로또 정상 생성 테스트")
    @Test
    void createWinningLotto() {
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @DisplayName("당첨 로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoWithDuplicateBonusNumber() {
        int bonusNumber = 6;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 최소 범위보다 작으면 예외가 발생한다.")
    @Test
    void bonusNumberLessThanRange() {
        int bonusNumber = 0;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 최소 범위보다 크면 예외가 발생한다.")
    @Test
    void bonusNumberGreaterThanRange() {
        int bonusNumber = 46;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}