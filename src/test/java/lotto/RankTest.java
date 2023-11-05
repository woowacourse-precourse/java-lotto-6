package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("매치 수에 맞는 랭크를 반환한다.")
    @Test
    void 매치_수에_맞는_랭크_반환() {
        // given
        int matchCout = 6;

        // when
        Rank rank = Rank.valueOf(matchCout);

        // then
        assertEquals(Rank.FIRST, rank);
    }
}
