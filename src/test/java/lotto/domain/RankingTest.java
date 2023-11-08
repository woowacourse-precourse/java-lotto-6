package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {
    
    @DisplayName("해당 등수의 개수를 받아서 해당 등수의 총 상금을 구한다.")
    @Test
    void calculatePrizeMoney() {
        // given
        int count = 5;
        int prizeMoney = Ranking.FIFTH.getPrizeMoney();
        
        long expected = (long) prizeMoney * count;
        
        // when
        long actual = Ranking.FIFTH.calculatePrizeMoney(count);
        
        // then
        assertThat(actual).isEqualTo(expected);
    }
}
