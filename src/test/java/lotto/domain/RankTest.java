package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("등수에 맞는 객체를 생성할 수 있다.")
    @Test
    void createRankTest() {
        Rank rank = Rank.createRank(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST_PRIZE);
        assertThat(rank.getMatchCount()).isEqualTo(6);
    }

    @DisplayName("일치하는 번호가 5개면서 보너스 번호도 맞추면 2등")
    @Test
    void secondPrizeTest() {
        Rank rank = Rank.createRank(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND_PRIZE);
    }

    @DisplayName("일치하는 번호가 5개고 보너스 번호가 다르면 3등")
    @Test
    void thirdPriceTest() {
        Rank rank = Rank.createRank(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD_PRIZE);
    }

    @DisplayName("등수에 들지 못한 순위는 제외한다.")
    @Test
    void filterNonPrizeTest() {
        List<Rank> ranks = Rank.filterGetPrize();

        assertThat(ranks).doesNotContain(Rank.NONE_PRIZE);
    }
}