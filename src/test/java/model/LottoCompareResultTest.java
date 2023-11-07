package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCompareResultTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 0, 1, 1, 2, 2})
    void 동일한_숫자_개수가_3개_미만일_때_빈_Optional_이_반환되어야_한다(final int equalCount) {
        // given
        LottoCompareResult result1 = new LottoCompareResult(equalCount, false);
        LottoCompareResult result2 = new LottoCompareResult(equalCount, true);

        // when
        Optional<LottoRank> resultRank1 = result1.getResultRank();
        Optional<LottoRank> resultRank2 = result2.getResultRank();

        // then
        assertAll(() -> {
            assertTrue(resultRank1.isEmpty());
            assertTrue(resultRank2.isEmpty());
        });
    }

    @Test
    void 맞춘_개수가_3개면_보너스볼_여부와_관계없이_FIFTH가_반환되어야_한다() {
        assertByCount(3, false, LottoRank.FIFTH);
        assertByCount(3, true, LottoRank.FIFTH);
    }

    @Test
    void 맞춘_개수가_4개면_보너스볼_여부와_관계없이_FORTH가_반환되어야_한다() {
        assertByCount(4, false, LottoRank.FORTH);
        assertByCount(4, true, LottoRank.FORTH);
    }

    @Test
    void 맞춘_개수가_5개_이고_보너스볼이_다르면_THIRD가_반환되어야_한다() {
        assertByCount(5, false, LottoRank.THIRD);
    }

    @Test
    void 맞춘_개수가_5개_이고_보너스볼이_같으면_SECOND가_반환되어야_한다() {
        assertByCount(5, true, LottoRank.SECOND);
    }

    @Test
    void 맞춘_개수가_6개면_보너스볼_여부와_관계없이_FIRST가_반환되어야_한다() {
        assertByCount(6, true, LottoRank.FIRST);
        assertByCount(6, false, LottoRank.FIRST);

    }

    void assertByCount(final int count, final boolean hasSameBonusBall, final LottoRank rank) {
        // given
        LottoCompareResult result = new LottoCompareResult(count, hasSameBonusBall);

        // when
        Optional<LottoRank> resultRank = result.getResultRank();

        // then
        assertEquals(rank, resultRank.get());
    }
}
