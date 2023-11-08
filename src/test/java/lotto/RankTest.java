package lotto;

import lotto.domain.Rank;

import static lotto.util.Util.formatCurrency;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("로또 당첨 시 올바른 등수를 호출하는지 확인한다.")
    @Test
    void getRank() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또 당첨 시 해당하는 상금을 올바르게 호출하는지 확인한다.")
    @Test
    void getPrizeWithRank() {
        assertThat(formatCurrency(Rank.FIRST.getWinnings()).replace(",", "")).isEqualTo("2000000000");
        assertThat(formatCurrency(Rank.SECOND.getWinnings()).replace(",", "")).isEqualTo("30000000");
        assertThat(formatCurrency(Rank.THIRD.getWinnings()).replace(",", "")).isEqualTo("1500000");
        assertThat(formatCurrency(Rank.FOURTH.getWinnings()).replace(",", "")).isEqualTo("50000");
        assertThat(formatCurrency(Rank.FIFTH.getWinnings()).replace(",", "")).isEqualTo("5000");
    }
}
