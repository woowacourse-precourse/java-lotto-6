package lotto.domain.model;

import lotto.domain.model.Result;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void 여섯개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.SIX_MATCH, Result.of(6, false));
    }

    @Test
    void 다섯개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.FIVE_MATCH, Result.of(5, false));
    }

    @Test
    void 보너스번호를_포함한_다섯개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.FIVE_MATCH_WITH_BONUS, Result.of(5, true));
    }

    @Test
    void 네개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.FOUR_MATCH, Result.of(4, false));
    }

    @Test
    void 세개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.THREE_MATCH, Result.of(3, false));
    }

    @Test
    void 보너스_번호를_포함하더라도_여섯개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.SIX_MATCH, Result.of(6, true));
    }

    @Test
    void 보너스_번호를_포함하더라도_네개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.FOUR_MATCH, Result.of(4, true));
    }

    @Test
    void 보너스_번호를_포함하더라도_세개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.THREE_MATCH, Result.of(3, true));
    }

    @Test
    void Result_결과에_따라_총_상금을_계산한다() {
        List<Result> results = List.of(
                Result.SIX_MATCH, Result.SIX_MATCH,
                Result.FIVE_MATCH_WITH_BONUS, Result.FIVE_MATCH_WITH_BONUS,
                Result.FIVE_MATCH, Result.FIVE_MATCH,
                Result.FOUR_MATCH, Result.FOUR_MATCH,
                Result.THREE_MATCH, Result.THREE_MATCH
        );

        Long expected = 2_000_000_000L + 2_000_000_000L
                + 30_000_000L + 30_000_000L
                + 1_500_000L + 1_500_000L
                + 50_000L + 50_000L
                + 5_000L + 5_000L;

        assertEquals(expected, Result.sumOfRewards(results));
    }

    @Test
    void 로또가_전부_일치하지_않은경우_0원을_계산한다() {
        List<Result> results = List.of();

        Long expected = 0L;

        assertEquals(expected, Result.sumOfRewards(results));
    }
}
