package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("일치번호 및 보너스번호 일치 결과를 통해 등수를 반환하는 기능.")
    @Test
    void 등수_반환() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRank(2, false)).isEqualTo(null);
    }

    @DisplayName("등수별 출력 문구 반환 기능.")
    @Test
    void 등수별_출력문_반환() {
        assertThat(Rank.FIRST.getRankMessage()).isEqualTo("6개 일치 (2,000,000,000원)");
        assertThat(Rank.SECOND.getRankMessage()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
        assertThat(Rank.THIRD.getRankMessage()).isEqualTo("5개 일치 (1,500,000원)");
        assertThat(Rank.FOURTH.getRankMessage()).isEqualTo("4개 일치 (50,000원)");
        assertThat(Rank.FIFTH.getRankMessage()).isEqualTo("3개 일치 (5,000원)");
    }
}
