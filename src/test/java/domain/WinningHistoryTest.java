package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WinningHistoryTest {

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증합니다. 6개가 일치하였다면, 1등입니다.")
    @Test
    void checkFirst() {
        assertThat(WinningHistory.calculateRank(6, false))
                .isEqualTo(WinningHistory.FIRST);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증합니다. 5개가 일치하면서 보너스번호까지 맞추었다면, 2등입니다.")
    @Test
    void checkSecond(){
        assertThat(WinningHistory.calculateRank(5, true))
                .isEqualTo(WinningHistory.SECOND);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증합니다. 5개가 일치하면서 보너스번호는 맞추지 못했다면, 3등입니다.")
    @Test
    void checkThird(){
        assertThat(WinningHistory.calculateRank(5, false))
                .isEqualTo(WinningHistory.THIRD);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증합니다. 4개가 일치하면, 4등입니다.")
    @Test
    void checkFourth(){
        assertThat(WinningHistory.calculateRank(4, false))
                .isEqualTo(WinningHistory.FOURTH);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수를 검증합니다. 3개가 일치하면, 5등입니다.")
    @Test
    void checkFifth(){
        assertThat(WinningHistory.calculateRank(3, false))
                .isEqualTo(WinningHistory.FIFTH);
    }

    @DisplayName("1등부터 5등이 아닌 나머지 등수를 검증합니다.")
    @Test
    void checkNonTopFiveRanks(){
        WinningHistory result = WinningHistory.calculateRank(2, false);
        assertNull(result);
    }


}
