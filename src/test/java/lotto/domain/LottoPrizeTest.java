package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {
    @DisplayName("로또 번호 맞춘 갯수")
    @Test
    void testGetMatches() {
        assertThat(LottoPrize.THREE_MATCHES.getMatches()).isEqualTo(3);
        assertThat(LottoPrize.FOUR_MATCHES.getMatches()).isEqualTo(4);
        assertThat(LottoPrize.FIVE_MATCHES.getMatches()).isEqualTo(5);
        assertThat(LottoPrize.FIVE_PLUS_BONUS.getMatches()).isEqualTo(5);
        assertThat(LottoPrize.SIX_MATCHES.getMatches()).isEqualTo(6);
    }

    @DisplayName("로또 상금")
    @Test
    void testGetPrize() {
        assertThat(LottoPrize.THREE_MATCHES.getPrize()).isEqualTo(5_000);
        assertThat(LottoPrize.FOUR_MATCHES.getPrize()).isEqualTo(50_000);
        assertThat(LottoPrize.FIVE_MATCHES.getPrize()).isEqualTo(1_500_000);
        assertThat(LottoPrize.FIVE_PLUS_BONUS.getPrize()).isEqualTo(30_000_000);
        assertThat(LottoPrize.SIX_MATCHES.getPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("로또 보너스 여부")
    @Test
    void testIsBonus() {
        assertThat(LottoPrize.THREE_MATCHES.isBonus()).isFalse();
        assertThat(LottoPrize.FOUR_MATCHES.isBonus()).isFalse();
        assertThat(LottoPrize.FIVE_MATCHES.isBonus()).isFalse();
        assertThat(LottoPrize.FIVE_PLUS_BONUS.isBonus()).isTrue();
        assertThat(LottoPrize.SIX_MATCHES.isBonus()).isFalse();
    }
}