package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersWithBonusTest {

    @DisplayName("번호 일치 개수 반환")
    @Test
    void returnCountMatchingNumbers() {
        assertThat(WinningNumbersWithBonus.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), Ball.from(7))
                .countMatchingNumbers(Lotto.of(List.of(1, 2, 3, 4, 10, 11)))).isEqualTo(4);
    }

    @DisplayName("보너스 볼 포함여부 반환")
    @Test
    void retunrIsContainBonus() {
        assertThat(WinningNumbersWithBonus.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), Ball.from(7))
                .bonusIn(Lotto.of(List.of(7, 8, 9, 10, 11, 12)))).isTrue();
    }
}
