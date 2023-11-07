package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoRankCountTest {
    @DisplayName("로또 등수가 1등에서 5등 사이가 아니면 예외가 발생한다.")
    @Test
    void createRankOutOfRange() {
        assertThatThrownBy(() -> new LottoRankCount().incrementCount(0))
                .isInstanceOf(IllegalStateException.class);
    }
}
