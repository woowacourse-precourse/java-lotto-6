package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WinningResultTest {
    @Test
    void 등수에_대한_당첨_개수를_포맷팅한다() {
        WinningResult winningResult = new WinningResult(WinningRule.THIRD_PRIZE, 2);

        assertThat(winningResult.format())
                .isEqualTo("5개 일치 (1,500,000원) - 2개\n");
    }
}
