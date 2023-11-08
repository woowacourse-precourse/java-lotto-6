package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinLottoTest {

    @Test
    @DisplayName("보너스 번호와 Lotto 번호가 중복되는 경우 예외가 발생한다.")
    void validateBonusDuplicate() {
        assertThatThrownBy(() -> new WinLotto(List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호가 보너스 번호와 중복되어서는 안됩니다.");
    }

    @Test
    @DisplayName("보너스 번호가 범위를 넘어서는 경우 예외가 발생한다.")
    void validateBonusRange() {
        assertThatThrownBy(() -> new WinLotto(List.of(1,2,3,4,5,6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1에서 45까지 입력 가능합니다.");
    }

}