package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void 모든_랭킹정보를_가져온다() {
        List<Ranking> allRankingCase = Ranking.getAllRankingCase();
        assertEquals(allRankingCase.size(), 6);
    }

}