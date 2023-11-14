package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

    @DisplayName("숫자 일치 개수와 보너스 숫자 일치 여부에 따른 순위 반환 테스트")
    @ParameterizedTest
    @CsvSource({"1, false, ONE", "2, false, TWO", "3, false, THREE", "4, false, FOUR", "5, false, FIVE",
            "5, true, FIVE_BONUS", "6, false, SIX",})
    void getPrizeByMatchCountAndLottoTest(int matchCount, boolean isBonusNumberMatch, Prize target) {
        Prize prize = Prize.getPrizeByMatchCountAndLotto(matchCount, isBonusNumberMatch);
        assertEquals(prize, target);
    }
}