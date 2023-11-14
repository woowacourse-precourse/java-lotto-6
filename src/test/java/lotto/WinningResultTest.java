package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {
    @DisplayName("당첨 개수 카운트 증가 테스트")
    @Test
    void incrementCount() {
        WinningResult.BONUS_MATCH.incrementCount();
        int count = WinningResult.BONUS_MATCH.getCount();
        Assertions.assertThat(count).isEqualTo(1);
    }
}