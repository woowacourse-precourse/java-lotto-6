package lotto.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Rank;

public class RankTest {
    @Test
    @DisplayName("모든 번호가 일치할 경우 FIRST을 반환해야한다")
    void firstWinTest() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
    }
    @Test
    @DisplayName("다섯개의 번호와 보너스 번호가 맞을 경우 SECOND를 반환해야한다")
    void secondWinTest() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }
    @Test
    @DisplayName("다섯개의 번호는 일치하고 보너스 번호는 일치하지 않을 경우 THIRD를 반환해야한다")
    void thirdWinTest() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }
    @Test
    @DisplayName("한개의 번호만이 일치할 경우 NONE을 반환해야한다")
    void noneWinTest() {
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.NONE);
    }

}
