package lotto.domain;

import static lotto.domain.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingTest {
    @Test
    @DisplayName("일치 횟수에 해당하는 Ranking을 반환하는 테스트")
    void findByMatchCount_test(){
        assertThat(Ranking.findByMatchCount(3)).isEqualTo(THREE_MATCHES);
        assertThat(Ranking.findByMatchCount(4)).isEqualTo(FOUR_MATCHES);
        assertThat(Ranking.findByMatchCount(6)).isEqualTo(SIX_MATCHES);
    }
}
