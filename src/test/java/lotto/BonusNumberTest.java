package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {//다 지우고 다시하셈

    @DisplayName("로또 보너스 번호에 유효하지 않은 문자열이 포함되면 예외가 발생한다.")
    @Test
    void createLottoByInvalidString() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, Integer.parseInt("A"))))
                .isInstanceOf(NumberFormatException.class);
    }
    @DisplayName("로또 보너스 번호가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByInvalidBonusNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 보너스 번호가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateBonusNumberInWinningNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
