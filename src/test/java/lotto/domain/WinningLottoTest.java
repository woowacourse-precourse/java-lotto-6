package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    
    @Test
    @DisplayName("당첨 번호 생성 테스트")
    void createWinningNumbers() {
        String winningNumbers = "1,2,3,4,5,6";
        Lotto lotto = WinningLotto.createWinningNumbers(winningNumbers);
        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("유효하지 않은 당첨 번호 입력 예외 상황")
    void invalidWinningNumbers() {
        String winningNumbers = "1,2,3,47,5,4";
        assertThatThrownBy(() -> WinningLotto.createWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복 되는 예외 상황")
    void duplicateBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String bonusNumber = "1";
        assertThatThrownBy(() -> WinningLotto.createBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
