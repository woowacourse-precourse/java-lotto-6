package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RankTest {
    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증한다. 6개가 일치하였다면, 1등.")
    @Test
    void checkFirst() {
        assertThat(Rank.calculateRank(6, false))
                .isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증한다. 5개가 일치하면서 보너스번호까지 맞추었다면, 2등.")
    @Test
    void checkSecond(){
        assertThat(Rank.calculateRank(5, true))
                .isEqualTo(Rank.SECOND);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증한다. 5개가 일치하면서 보너스번호는 맞추지 못했다면, 3등.")
    @Test
    void checkThird(){
        assertThat(Rank.calculateRank(5, false))
                .isEqualTo(Rank.THIRD);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증한다. 4개가 일치하면, 4등.")
    @Test
    void checkFourth(){
        assertThat(Rank.calculateRank(4, false))
                .isEqualTo(Rank.FOURTH);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증합니다. 3개가 일치하면, 5등입니다.")
    @Test
    void checkFifth(){
        assertThat(Rank.calculateRank(3, false))
                .isEqualTo(Rank.FIFTH);
    }

    @DisplayName("1등부터 5등이 아닌 나머지 등수를 검증합니다.")
    @Test
    void checkNonTopFiveRanks(){
        Rank result = Rank.calculateRank(2, false);
        assertNull(result);
    }
}
