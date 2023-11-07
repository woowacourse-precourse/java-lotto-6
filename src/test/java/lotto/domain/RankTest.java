package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("ENUM Rank를 결정하는 도메인 로직 테스트")
    @Test
    void decideRankTest() {
        Rank rank;

        rank = Rank.decideRank(5, true);
        Assertions.assertThat(rank.getWinningMessage()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
    }
}
