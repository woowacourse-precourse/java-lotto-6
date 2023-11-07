package lotto.model;

import static lotto.model.Ranking.BONUS;
import static lotto.model.Ranking.FOUR;
import static lotto.model.Ranking.NOTHING;
import static lotto.model.Ranking.THREE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    Statistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new Statistics();
        statistics.makeResultBoard();
    }

    @Test
    void 랭킹점수_보드를_만든다() {
        int size = statistics.getResults().size();

        List<Ranking> allRankingCase = Ranking.getAllRankingCase();
        Map<Ranking, Integer> resultBoard = statistics.getResults();

        //랭킹 값 중 아무런 경우도 아닌 Nothing은 제외한다.
        assertFalse(resultBoard.containsKey(NOTHING));
        assertEquals(size, allRankingCase.size() - 1);
    }

    @Test
    void 랭킹결과_리스트에_따라_점수를_업데이트한다() {
        List<Ranking> rankings = new ArrayList<>(List.of(NOTHING, THREE, FOUR, BONUS, THREE, NOTHING));
        statistics.createData(rankings);

        Map<Ranking, Integer> resultBoard = statistics.getResults();

        assertEquals(2, resultBoard.get(THREE));
        assertEquals(1, resultBoard.get(FOUR));
        assertEquals(1, resultBoard.get(BONUS));
    }

    @Test
    void 수익률을_계산한다() {
        Purchase purchase = new Purchase("5000");
        List<Ranking> rankings = new ArrayList<>(List.of(NOTHING, THREE, FOUR, BONUS, THREE, NOTHING));

        statistics.createData(rankings);
        float rateOfReturn = statistics.calculateRateOfReturn(purchase);

        assertEquals(601200.0 ,rateOfReturn);
    }

}