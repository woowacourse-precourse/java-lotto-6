package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("매치 수에 맞는 랭크를 반환한다.")
    @Test
    void 매치_수에_맞는_랭크_반환() {
        // given
        int matchCout = 5;
        boolean isBonus = true;

        // when
        Rank rank = Rank.valueOf(matchCout, isBonus);

        // then
        assertEquals(Rank.SECOND, rank);
    }
}
