package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeResultTest {

    @DisplayName("최종 상금이 0으로 초기화된 상금 결과 객체를 생성한다.")
    @Test
    void createPrizeResultWithTotalPrizeZero() {
        assertThat(new LottoPrizeResult()
                .getTotalPrize())
                .isEqualTo(0);
    }

    @DisplayName("전달한 상금만큼 최종 상금이 증가한다.")
    @Test
    void increaseTotalPrizeAsInputPrize() {
        long prizeAdd = 1000;
        LottoPrizeResult prizeResult = new LottoPrizeResult();
        assertThat(prizeResult
                .getTotalPrize())
                .isEqualTo(0);

        prizeResult.addTotalPrize(prizeAdd);

        assertThat(prizeResult
                .getTotalPrize())
                .isEqualTo(prizeAdd);
    }

}