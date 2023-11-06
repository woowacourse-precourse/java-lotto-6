package lotto;

import lotto.domain.Winnings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerTest {

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외를 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Winnings(List.of(1, 2, 3, 4, 5, 6), 46))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 발생한다.")
    @Test
    void createLottoByLowSize() {
        assertThatThrownBy(() -> new Winnings(List.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(IllegalArgumentException.class);
    }
}