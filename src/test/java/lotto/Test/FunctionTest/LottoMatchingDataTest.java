package lotto.Test.FunctionTest;

import lotto.model.lottoResultChecker.LottoMatchingData;
import lotto.model.lottoResultChecker.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class LottoMatchingDataTest {

    private LottoMatchingData matchingData;

    @BeforeEach
    void setUp() {
        matchingData = new LottoMatchingData();
    }

    @Test
    @DisplayName("LottoRank에 해당하는 매치 카운트를 추가할 수 있어야 한다")
    void AddMatchCountToLottoRankTest() {
        matchingData.addMatch(LottoRank.FIRST);
        matchingData.addMatch(LottoRank.SECOND);
        matchingData.addMatch(LottoRank.SECOND);

        Map<LottoRank, Integer> rankCount = matchingData.getRankCount();

        assertEquals(1, rankCount.get(LottoRank.FIRST), "1등 매치 카운트가 정확해야 한다");
        assertEquals(2, rankCount.get(LottoRank.SECOND), "2등 매치 카운트가 정확해야 한다");
        assertEquals(0, rankCount.get(LottoRank.THIRD), "3등 매치 카운트는 증가하지 않았어야 한다");
        assertEquals(0, rankCount.get(LottoRank.FOURTH), "4등 매치 카운트는 증가하지 않았어야 한다");
        assertEquals(0, rankCount.get(LottoRank.FIFTH), "5등 매치 카운트는 증가하지 않았어야 한다");
        assertEquals(0, rankCount.get(LottoRank.NONE), "미당첨 매치 카운트는 증가하지 않았어야 한다");
    }
}
