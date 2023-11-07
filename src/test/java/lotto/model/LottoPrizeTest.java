package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("상급 테스트")
class LottoPrizeTest {
    @ParameterizedTest
    @CsvSource({"6, true", "6, false",})
    void 상금_1등_테스트(int matchCount, boolean matchBonus) {
        assertThat(LottoPrize.valueOf(matchCount, matchBonus).getPrizeRank()).isEqualTo(6);
        assertThat(LottoPrize.valueOf(matchCount, matchBonus).getPrizeMoney()).isEqualTo(2000000000);
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

    @ParameterizedTest
    @CsvSource({"4, true", "4, false",})
    void 상금_4등_테스트(int matchCount, boolean matchBonus) {
        assertThat(LottoPrize.valueOf(matchCount, matchBonus).getPrizeRank()).isEqualTo(4);
        assertThat(LottoPrize.valueOf(matchCount, matchBonus).getPrizeMoney()).isEqualTo(50000);
    }

    @ParameterizedTest
    @CsvSource({"3, true", "3, false",})
    void 상금_5등_테스트(int matchCount, boolean matchBonus) {
        assertThat(LottoPrize.valueOf(matchCount, matchBonus).getPrizeRank()).isEqualTo(3);
        assertThat(LottoPrize.valueOf(matchCount, matchBonus).getPrizeMoney()).isEqualTo(5000);
    }

    @ParameterizedTest
    @CsvSource({
            "2, true", "1, true", "0, true",
            "2, false", "1, false", "0, false"
    })
    void 상금_외_테스트(int matchCount, boolean matchBonus) {
        assertThat(LottoPrize.valueOf(matchCount, matchBonus).getPrizeRank()).isEqualTo(0);
        assertThat(LottoPrize.valueOf(matchCount, matchBonus).getPrizeMoney()).isEqualTo(0);
    }

}