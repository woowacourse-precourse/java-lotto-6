package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("인덱스 값을 반환한다.")
    void getRankIndexTest() {
        assertThat(FIRST.getRankIndex()).isEqualTo(0);
        assertThat(THIRD.getRankIndex()).isEqualTo(2);
        assertThat(FIFTH.getRankIndex()).isEqualTo(4);
    }

    @Test
    @DisplayName("등수에 따라 맞춰야 하는 갯수를 반환한다.")
    void getMatchedCountTest() {
        assertThat(FIRST.getMatchedCount()).isEqualTo(6);
        assertThat(SECOND.getMatchedCount()).isEqualTo(15);
        assertThat(FIFTH.getMatchedCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨금을 반환한다.")
    void getPrizeTest() {
        assertThat(FIRST.getPrize()).isEqualTo(2000000000);
        assertThat(SECOND.getPrize()).isEqualTo(30000000);
        assertThat(FIFTH.getPrize()).isEqualTo(5000);
    }

    @Test
    @DisplayName("2등은 식별자로 10을 반환한다.")
    void getIdentifierTest() {
        assertThat(SECOND.getIdentifier()).isEqualTo(10);
    }
}