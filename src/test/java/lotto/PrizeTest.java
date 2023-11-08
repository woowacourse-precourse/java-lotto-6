package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @DisplayName("당첨에 해당하는 일치 개수와 로또의 일치 개수를 비교해 해당 등수를 반환한다.")
    @Test
    void returnPrize() {
        int userMatchedCount = 3;
        assertThat(Prize.getPrize(userMatchedCount)).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("당첨에 해당하는 일치 개수가 3 미만이면 NONE을 반환한다.")
    @Test
    void returnNonePrize() {
        int userMatchedCount = 2;
        assertThat(Prize.getPrize(userMatchedCount)).isEqualTo(Prize.NONE);
    }
}