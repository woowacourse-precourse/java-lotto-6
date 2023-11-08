package lotto.model.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeInfoTest {
    @DisplayName("조건에 일치하는 enum이 맞는지 반환한다.")
    @Test
    void returnEnumIsMatchByMatchingNumberAndBonusMatch() {
        assertThat(PrizeInfo.PRIZE_1.isMatch(6, false)).
                isEqualTo(true);
        assertThat(PrizeInfo.PRIZE_2.isMatch(5, true)).
                isEqualTo(true);
        assertThat(PrizeInfo.PRIZE_3.isMatch(5, false)).
                isEqualTo(true);
    }
}