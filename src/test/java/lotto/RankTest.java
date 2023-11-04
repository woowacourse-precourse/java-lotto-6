package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("일치번호 및 보너스번호 일치 결과를 통해 등수를 반환하는 기능.")
    @Test
    void 등수_반환(){
        assertThat(Rank.getRank(6,false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5,true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(5,false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(4,false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(3,false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRank(2,false)).isEqualTo(null);
    }
}
