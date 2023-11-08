package lotto.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("다섯개 번호와 보너스 번호가 일치한다면 2등이다.")
    @Test
    void mustBeSecond() {
        Rank actual = Rank.calculateRank(5, true);
        assertEquals(Rank.SECOND, actual);
    }

    @DisplayName("다섯개 번호만 일치한다면 3등이다.")
    @Test
    void mustBeThird() {
        Rank actual = Rank.calculateRank(5, false);
        assertEquals(Rank.THIRD, actual);
    }
}