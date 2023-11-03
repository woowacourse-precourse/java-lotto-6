package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

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

    @DisplayName("번호가 2개이하 맞았을 땐 NO_RANK를 반환한다")
    @Test
    void noRankTest() {
        assertEquals(Rank.NO_RANK, Rank.decideRank(2, true));
    }

}
