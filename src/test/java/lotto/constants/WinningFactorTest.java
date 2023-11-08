package lotto.constants;

import lotto.constants.lotto.WinningFactor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 조건 요소 상수에 대해")
class WinningFactorTest {

    @Test
    @DisplayName("일치 개수와 보너스 번호 판별을 비교하여 일치하는 상수를 반환한다.")
    void Given_MatchThree_When_FindWinningFactorByCondition_Then_GetTheeMatch() {
        //given
        Integer count = 3;
        Boolean isMatchBonusNumber = false;

        //when
        WinningFactor actual = WinningFactor.findWinningFactorByCondition(count, isMatchBonusNumber);

        //then
        assertThat(actual).isEqualTo(WinningFactor.THREE_MATCH);
    }

    @Test
    @DisplayName("일치 개수와 보너스 번호 판별을 비교하여 일치하지 않으면 NONE_MATCH 상수를 반환한다.")
    void Given_NoneMatch_When_FindWinningFactorByCondition_Then_NoneMatch() {
        //given
        Integer count = 1;
        Boolean isMatchBonusNumber = true;

        //when
        WinningFactor actual = WinningFactor.findWinningFactorByCondition(count, isMatchBonusNumber);

        //then
        assertThat(actual).isEqualTo(WinningFactor.NONE_MATCH);
    }
}
