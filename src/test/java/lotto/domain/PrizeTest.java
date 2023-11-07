package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.prize.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("당첨 기준에 맞게 등수를 구분하는지 테스트")
    @Test
    void determineRank() {
        int winningNumberCount = 5;
        boolean isBonusNumberMatched = true;
        Prize expectedPlace = Prize.SECOND_PLACE;

        Prize determineRank = Prize.determineRank(winningNumberCount, isBonusNumberMatched);

        assertThat(determineRank).isEqualTo(expectedPlace);
    }
}