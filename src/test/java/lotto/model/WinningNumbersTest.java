package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

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

}
