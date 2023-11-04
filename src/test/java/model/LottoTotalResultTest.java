package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTotalResultTest {

    private LottoTotalResult totalResult;

    @BeforeEach
    void init() {
        totalResult = LottoTotalResult.createDefault();
    }

    @ParameterizedTest
    @CsvSource(value = {"3,false", "4,false", "5,false", "5,true", "6,false"})
    void 각_비교_결과를_반영했을_때_수익의_합은_반영_결과의_수익(int count, boolean bonusBallCondition) {
        // given
        LottoCompareResult compareResult = new LottoCompareResult(count, bonusBallCondition);

        // when
        totalResult.reflectCompareResult(compareResult);
        long reward = compareResult.getResultRank()
            .get()
            .getReward();

        // then
        assertEquals(reward, totalResult.getSum());
    }

    @Test
    void 반영_결과들의_수익의_합을_반환하는지_테스트() {
        // given
        LottoCompareResult compareResult1 = new LottoCompareResult(4, false);
        LottoCompareResult compareResult2 = new LottoCompareResult(5, false);

        long reward1 = compareResult1.getResultRank()
            .get()
            .getReward();
        long reward2 = compareResult2.getResultRank()
            .get()
            .getReward();

        // when
        totalResult.reflectCompareResult(compareResult1);
        totalResult.reflectCompareResult(compareResult2);

        // then
        assertEquals(reward1 + reward2, totalResult.getSum());
    }
}

