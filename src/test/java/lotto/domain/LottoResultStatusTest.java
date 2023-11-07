package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.lottoresult.LottoResultStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultStatusTest {

    @ParameterizedTest
    @CsvSource({
            "0, true, FAIL",
            "1, false, FAIL",
            "2, false, FAIL"
    })
    @DisplayName("맞힌 개수가 3개 미만이면 보너스번호와 상관없이 FAIL 이다.")
    void testFailWinningStatus(int matchCount, boolean withBonusNum, LottoResultStatus expected) {
        LottoResultStatus result = LottoResultStatus.checkResult(matchCount, withBonusNum);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "3, false, THREE_MATCH",
            "4, false, FOUR_MATCH",
            "5, false, FIVE_MATCH",
            "5, true, FIVE_MATCH_WITH_BONUS",
            "6, false, ALL_MATCH",
            "6, true, ALL_MATCH"
    })
    @DisplayName("맞힌 개수가 3개 이상이면 알맞은 결과를 나타낸다.")
    void testGetWinningStatus(int matchCount, boolean withBonusNum, LottoResultStatus expected) {
        LottoResultStatus result = LottoResultStatus.checkResult(matchCount, withBonusNum);

        assertEquals(expected, result);
    }
}