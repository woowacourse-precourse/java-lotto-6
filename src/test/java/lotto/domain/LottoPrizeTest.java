package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("상급 테스트")
class LottoPrizeTest {
    @Test
    void 상금_1등_테스트() {
        assertThat(LottoPrize.valueOf(6, false).getPrizeRank()).isEqualTo(6);
        assertThat(LottoPrize.valueOf(6, false).getPrizeMoney()).isEqualTo(2000000000);
        assertThat(LottoPrize.valueOf(6, true).getPrizeRank()).isEqualTo(6);
        assertThat(LottoPrize.valueOf(6, true).getPrizeMoney()).isEqualTo(2000000000);
    }
    @Test
    void 상금_2등_테스트() {
        assertThat(LottoPrize.valueOf(5, true).getPrizeRank()).isEqualTo(5);
        assertThat(LottoPrize.valueOf(5, true).getPrizeMoney()).isEqualTo(30000000);
    }
    @Test
    void 상금_3등_테스트() {
        assertThat(LottoPrize.valueOf(5, false).getPrizeRank()).isEqualTo(5);
        assertThat(LottoPrize.valueOf(5, false).getPrizeMoney()).isEqualTo(1500000);
    }
    @Test
    void 상금_4등_테스트() {
        assertThat(LottoPrize.valueOf(4, false).getPrizeRank()).isEqualTo(4);
        assertThat(LottoPrize.valueOf(4, false).getPrizeMoney()).isEqualTo(50000);
        assertThat(LottoPrize.valueOf(4, true).getPrizeRank()).isEqualTo(4);
        assertThat(LottoPrize.valueOf(4, true).getPrizeMoney()).isEqualTo(50000);
    }
    @Test
    void 상금_5등_테스트() {
        assertThat(LottoPrize.valueOf(3, false).getPrizeRank()).isEqualTo(3);
        assertThat(LottoPrize.valueOf(3, false).getPrizeMoney()).isEqualTo(5000);
        assertThat(LottoPrize.valueOf(3, true).getPrizeRank()).isEqualTo(3);
        assertThat(LottoPrize.valueOf(3, true).getPrizeMoney()).isEqualTo(5000);
    }
}