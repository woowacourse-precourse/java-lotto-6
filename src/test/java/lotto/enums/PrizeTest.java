package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @DisplayName("일치한 로또 번호 개수와 보너스 번호에 해당하는 당첨금을 반환한다.")
    @Test
    void getPrize() {
        // given
        int winCount = 5;

        // when
        int secondPrize = Prize.getPrize(winCount, true);
        int thirdPrize = Prize.getPrize(winCount, false);

        // then
        assertThat(secondPrize).isEqualTo(30_000_000);
        assertThat(thirdPrize).isEqualTo(1_500_000);
    }

}