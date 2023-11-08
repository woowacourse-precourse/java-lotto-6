package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfRanksTest {

    @DisplayName("랭크의 수를 추가한다.")
    @Test
    void addNumberOfRanks() {
        // given
        NumberOfRanks numberOfRanks = NumberOfRanks.count();
        Rank rank = Rank.FIRST;

        // when
        numberOfRanks.addRank(rank);

        // then
        assertEquals(1, numberOfRanks.getRankCount(rank));
    }
}
