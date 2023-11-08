package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("번호가 6개 맞았을 땐 1등을 반환한다")
    @Test
    void firstRankTest() {
        assertEquals(Rank.FIRST, Rank.decideRank(6, false));
    }

    @DisplayName("번호가 5개 맞고 보너스번호까지 맞았을 땐 2등을 반환한다")
    @Test
    void secondRankTest() {
        assertEquals(Rank.SECOND, Rank.decideRank(5, true));
    }

    @DisplayName("번호가 5개 일치하고 보너스번호는 틀렸을 때 3등을 반환한다")
    @Test
    void thirdRankTest() {
        assertEquals(Rank.THIRD, Rank.decideRank(5, false));
    }

    @DisplayName("번호가 4개 맞았을 땐 보너스 번호 일치여부와 관계없이 4등을 반환한다")
    @Test
    void fourthRankTest() {
        assertEquals(Rank.FOURTH, Rank.decideRank(4, false));
        assertEquals(Rank.FOURTH, Rank.decideRank(4, true));
    }

    @DisplayName("번호가 3개 맞았을 땐 보너스 번호 일치여부와 관계없이 4등을 반환한다")
    @Test
    void fifthRankTest() {
        assertEquals(Rank.FIFTH, Rank.decideRank(3, false));
        assertEquals(Rank.FIFTH, Rank.decideRank(3, true));
    }

    @DisplayName("번호가 2개이하 맞았을 땐 보너스 번호 일치여부와 관계없이 NO_RANK를 반환한다")
    @Test
    void noRankTest() {
        assertEquals(Rank.NO_RANK, Rank.decideRank(2, true));
        assertEquals(Rank.NO_RANK, Rank.decideRank(1, true));
        assertEquals(Rank.NO_RANK, Rank.decideRank(0, true));
        assertEquals(Rank.NO_RANK, Rank.decideRank(2, false));
        assertEquals(Rank.NO_RANK, Rank.decideRank(1, false));
        assertEquals(Rank.NO_RANK, Rank.decideRank(0, false));
    }

}
