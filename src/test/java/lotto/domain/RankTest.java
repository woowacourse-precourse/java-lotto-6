package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    @DisplayName("당첨된 등수에 따라 당첨 횟수가 증가하는 테스트")
    void increaseCountTest() {
        final int matchResult = 5;
        final boolean hasBonusNumber = false;
        increaseRankResult(matchResult, hasBonusNumber);
        assertThat(THIRD.getWinningAmount())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 금액을 확인하는 테스트")
    void totalEarningMoneyTest(){
        final int matchResult = 4;
        final boolean hasBonusNumber = false;
        increaseRankResult(matchResult, hasBonusNumber);
        assertThat(FOURTH.getMoney())
                .isEqualTo(50000);
    }
}
