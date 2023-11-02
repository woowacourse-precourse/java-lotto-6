package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @DisplayName("3개 숫자가 같은 경우 LottoPrize.THREE_MATCH 반환")
    @Test
    void checkThird() {
        LottoPrize prize1 = LottoPrize.from(3, false);
        LottoPrize prize2 = LottoPrize.from(3, true);

        assertThat(prize1).isEqualTo(LottoPrize.THREE_MATCH);
        assertThat(prize2).isEqualTo(LottoPrize.THREE_MATCH);
    }
}