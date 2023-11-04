package lotto;

import lotto.model.Lotto;
import lotto.model.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {
    @DisplayName("당첨 로또 번호 길이가 6이 아니면 예외가 발생한다.")
    @Test
    void winningNumbersLength() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6, 7), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
