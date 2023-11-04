package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("로또 당첨 랭킹 객체 생성을 테스트한다.")
    @Test
    public void createRank() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isNotNull();
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또 당첨 랭킹 문구 변환을 테스트한다.")
    @Test
    public void formatMessage() {
        Rank rank = Rank.valueOf(3, false);
        String message = rank.formatMessage(1);
        assertThat(message).isEqualTo("3개 일치 (5,000원) - 1개");
    }
}