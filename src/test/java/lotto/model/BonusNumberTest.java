package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberIsNotNumber() {
        assertThatThrownBy(() -> new BonusNumber("7a", new WinningNumbers("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicated() {
        assertThatThrownBy(() -> new BonusNumber("6", new WinningNumbers("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호 범위 밖의 값이면 예외가 발생한다.")
    @Test
    void createBonusNumberInLottoNumberBounds() {
        assertThatThrownBy(() -> new BonusNumber("100", new WinningNumbers("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}