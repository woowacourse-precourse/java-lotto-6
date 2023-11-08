package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

	@DisplayName("일치하는 번호 개수에 해당하는 순위를 반환한다.")
    @Test
    void getRank() {
        int correctCount1 = 2;
        int correctCount2 = 5;
        int correctCount3 = 5;
        
        Rank result1 = Rank.ranking(correctCount1, true);
        Rank result2 = Rank.ranking(correctCount2, true);
        Rank result3 = Rank.ranking(correctCount3, false);
        
        assertThat(result1).isEqualTo(Rank.TWO_LOSE);
        assertThat(result2).isEqualTo(Rank.SECOND);
        assertThat(result3).isEqualTo(Rank.THIRD);
    }

}
