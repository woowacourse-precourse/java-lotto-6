package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("::6개의 숫자가 일치하고 보너스 번호가 포함되지 안으면 1등 객체가 반환된다")
    public void When_MatchesSixNumbers_HasNoBonus_Then_RankIsFirst() {
        Rank rank = Rank.FIRST;
        
        assertThat(rank.rankByCondition(6, false)).isEqualTo(Rank.FIRST);
    }
}
