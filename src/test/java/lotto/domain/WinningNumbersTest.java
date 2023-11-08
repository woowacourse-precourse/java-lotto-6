package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @DisplayName("보너스 번호가 일치하는지 확인한다.")
    @Test
    void isMatchBonus() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningNumbers.isMatchBonus(lotto)).isTrue();
    }

    @DisplayName("당첨 번호가 일치하는 개수를 계산한다.")
    @Test
    void calculateMatchCount() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(winningNumbers.calculateMatchCount(lotto)).isEqualTo(3);
    }
}
