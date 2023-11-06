package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("1등이라면 20억을 상금으로 받습니다.")
    @Test
    void getPrize() {
        assertThat(Rank.FIRST.prize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("2등이라면 3천만원을 상금으로 받습니다.")
    @Test
    void getPrize2() {
        assertThat(Rank.SECOND.prize()).isEqualTo(30_000_000);
    }

    @DisplayName("3등은 150만원을 상금으로 받습니다.")
    @Test
    void getPrize3() {
        assertThat(Rank.THIRD.prize()).isEqualTo(1_500_000);
    }

    @DisplayName("4등이라면 5만원을 상금으로 받습니다.")
    @Test
    void getPrize4() {
        assertThat(Rank.FOURTH.prize()).isEqualTo(50_000);
    }

    @DisplayName("5등은 5천원을 상금으로 받습니다.")
    @Test
    void getPrize5() {
        assertThat(Rank.FIFTH.prize()).isEqualTo(5_000);
    }

    @DisplayName("당첨이 안됐다면 0원 얻습니다.")
    @Test
    void getPrizeMiss() {
        assertThat(Rank.MISS.prize()).isEqualTo(0);
    }
}
