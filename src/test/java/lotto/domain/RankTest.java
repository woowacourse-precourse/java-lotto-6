package lotto.domain;

import lotto.model.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class RankTest {

    @DisplayName("해당하는 RANK를 반환하는지 확인한다.")
    @Test
    public void rankReturnTest(){
        // given
        int correctCount = 4;

        // when
        Rank rank = Rank.lottoRank(correctCount);

        // then
        assertThat(rank.getPrize()).isEqualTo(50000L);
    }

}
