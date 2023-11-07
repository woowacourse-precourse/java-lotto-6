package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.constans.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosResultTest {
    @DisplayName("당첨 등수가 주어지면 결과에 1을 더한다.")
    @Test
    void testUpdateLottosResult() {
        LottosResult lottosResult = LottosResult.create();
        lottosResult.updateResult(WinningRank.FIRST_PRIZE);

        assertThat(lottosResult.get(WinningRank.FIRST_PRIZE)).isEqualTo(1);
    }
}
