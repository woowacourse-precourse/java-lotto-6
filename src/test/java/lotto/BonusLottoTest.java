package lotto;

import lotto.domain.BonusLotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusLottoTest {
    @DisplayName("보너스 로또 입력값에 공백이 포함되면 예외가 발생한다.")
    @Test
    void inputBonusLottoWithSpaces() {
        assertThatThrownBy(() -> new BonusLotto("1 2", new WinningLotto("1, 2, 3, 4, 5, 6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputBonusLottoNotANumber() {
        assertThatThrownBy(() -> new BonusLotto("1A", new WinningLotto("1, 2, 3, 4, 5, 6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 입력값의 첫 숫자가 0인 경우 예외가 발생한다.")
    @Test
    void inputBonusLottoWithLeadingZero() {
        assertThatThrownBy(() -> new BonusLotto("01", new WinningLotto("1, 2, 3, 4, 5, 6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 입력값이 범위를 벗어나면 예외가 발생한다.")
    @Test
    void inputBonusLottoOutOfRange() {
        assertThatThrownBy(() -> new BonusLotto("50", new WinningLotto("1, 2, 3, 4, 5, 6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 입력값이 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void inputBonusLottoDuplicate() {
        assertThatThrownBy(() -> new BonusLotto("1", new WinningLotto("1, 2, 3, 4, 5, 6")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}