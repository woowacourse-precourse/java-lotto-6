package lotto.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningInfoTest {

    @DisplayName("로또 번호 일치 갯수와 보너스 번호 일치 여부에 따라 WinningInfo가 올바르게 생성된다.")
    @Test
    void createWinningInfoByMatchedCountAndIsBonuseMatched() {
        WinningInfo sixMatchInfo = WinningInfo.of(6, false);
        WinningInfo fiveAndBonusMatchInfo = WinningInfo.of(5, true);
        WinningInfo fiveMatchInfo = WinningInfo.of(5, false);
        WinningInfo fourMatchInfo = WinningInfo.of(4, false);
        WinningInfo threeMatchInfo = WinningInfo.of(3, false);
        WinningInfo noneInfo = WinningInfo.of(0, false);

        assertThat(sixMatchInfo).isEqualTo(WinningInfo.SIX_MATCH);
        assertThat(fiveAndBonusMatchInfo).isEqualTo(WinningInfo.FIVE_AND_BONUS_MATCH);
        assertThat(fiveMatchInfo).isEqualTo(WinningInfo.FIVE_MATCH);
        assertThat(fourMatchInfo).isEqualTo(WinningInfo.FOUR_MATCH);
        assertThat(threeMatchInfo).isEqualTo(WinningInfo.THREE_MATCH);
        assertThat(noneInfo).isEqualTo(WinningInfo.NONE);
    }

}