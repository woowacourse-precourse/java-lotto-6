package lotto.domain.dto;

import lotto.domain.Result;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    void statistics_내부_필드가_동일하다면_같은_객체로_인식한다() {
        List<Result> results = List.of(Result.FIVE_MATCH, Result.SIX_MATCH);
        Statistics statisticsA = new Statistics(results, 50.0);
        Statistics statisticsB = new Statistics(results, 50.0);

        assertEquals(statisticsA, statisticsB);
    }

    @Test
    void statistics_내부_필드가_동일하다면_Hash_자료구조에서도_객체로_인식한다() {
        Set<Statistics> set = new HashSet<>();
        List<Result> results = List.of(Result.FIVE_MATCH, Result.SIX_MATCH);
        Statistics statisticsA = new Statistics(results, 50.0);
        Statistics statisticsB = new Statistics(results, 50.0);

        set.add(statisticsA);
        set.add(statisticsB);

        assertEquals(1, set.size());
    }
}
