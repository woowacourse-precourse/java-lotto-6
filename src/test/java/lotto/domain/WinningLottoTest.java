package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    void WinningLotto_Constructor_ThrowsException_For_DuplicateBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
