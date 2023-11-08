package lotto.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class ResultTest {
    private Result result;

    @BeforeEach
    public void setUp() {
        result = new Result();
    }

    @Test
    @DisplayName("당첨 순위의 갯수를 저장")
    public void countRankNumber() {
        result.countRank(1);
        result.countRank(1);
        result.countRank(2);

        List<Integer> ranks = result.getRanks();

        assertEquals(2, ranks.get(1).intValue());
        assertEquals(1, ranks.get(2).intValue());

        for (int i = 0; i < Result.RANK_NUMBER; i++) {
            if (i != 1 && i != 2) {
                assertEquals(0, ranks.get(i).intValue());
            }
        }
    }

    @Test
    @DisplayName("당첨금의 총 합을 저장")
    public void addTotalIncome() {
        result.addIncome(50000);
        result.addIncome(100000);

        assertEquals(150000, result.getIncome(), 0.01);
    }
}
