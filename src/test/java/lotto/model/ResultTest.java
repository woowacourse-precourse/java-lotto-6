package lotto.model;

import static lotto.util.ExceptionMessage.MATCHING_COUNT_INVALID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultTest {

    @Test
    void 당첨번호와_로또번호가_겹치는_최대개수는_6개이다() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new Result(7, true));
        assertEquals(e.getMessage(), MATCHING_COUNT_INVALID.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,false,NOTHING",
        "1,true,NOTHING",
        "2,true,NOTHING",
        "3,true,THREE",
        "3,false,THREE",
        "4,true,FOUR",
        "4,false,FOUR",
        "5,true,BONUS",
        "5,false,FIVE",
        "6,true,SIX",
        "6,false,SIX",
    })
    void 결과를_통해_랭킹을_판단한다(int matchingCount, boolean isMatchedBonus, Ranking ranking) {
        Result result = new Result(matchingCount, isMatchedBonus);

        Ranking rank = result.findMatchingRanking();

        assertEquals(ranking, rank);
    }
}