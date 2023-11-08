package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    @DisplayName("당첨 번호가 잘 생성되는지 확인한다")
    void createWinningNumbers() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        assertThat(winningNumbers.getWinningLotto()).isEqualTo(winningLotto);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 존재할 경우 예외가 발생한다")
    void inputBonusNumberInWinningLotto() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
    }

}
