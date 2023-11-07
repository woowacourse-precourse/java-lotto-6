package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    @DisplayName("당첨 결과에 1등을 1번 추가하면 1등이 1개이다.")
    @Test
    void addResultByFirst() {
        // given
        WinningResult winningResult = new WinningResult();
        // when
        winningResult.addResult(Rank.FIRST);
        // then
        assertThat(winningResult.getCount(Rank.FIRST)).isEqualTo(1);
    }
}
