package lotto;

import lotto.domain.WinningRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningRankTest {

    @DisplayName("입력으로 주어진 맞춘 개수와 보너스 여부와 일치하는 것이 없다면 낫싱을 반환한다.")
    @Test
    void createWinningRankNothing() {
        int match = 6;
        boolean isBonus = true;
        Assertions.assertThat(WinningRank.from(match, isBonus))
                .isEqualTo(WinningRank.NOTHING);
    }
}
