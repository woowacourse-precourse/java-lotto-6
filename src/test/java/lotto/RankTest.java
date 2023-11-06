package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("조건에 맞는 랭크를 반환한다.")
    @Test
    void getRankTest() {
        assertThat(Rank.THIRD).isEqualTo(Rank.getRank(5,false));
    }
}
