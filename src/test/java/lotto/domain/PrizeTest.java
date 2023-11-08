package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {
    @Test
    @DisplayName("matchPrize 테스트 - matchCount가 6일때")
    public void matchPrize6Numbers() {
        Prize result = Prize.matchPrize(6, false);
        assertThat(result).isEqualTo(Prize.SIX_MATCH);
    }

    @Test
    @DisplayName("matchPrize 테스트 - matchCount가 5이고 보너스번호가 일치할때")
    public void matchPrize5NumbersAndBonus() {
        Prize result = Prize.matchPrize(5, true);
        assertThat(result).isEqualTo(Prize.FIVE_MATCH_BONUS);
    }

    @Test
    @DisplayName("matchPrize 테스트 - matchCount가 5일때")
    public void matchPrize5Numbers() {
        Prize result = Prize.matchPrize(5, false);
        assertThat(result).isEqualTo(Prize.FIVE_MATCH);
    }

    @Test
    @DisplayName("matchPrize 테스트 - matchCount가 4일때")
    public void matchPrize4Numbers() {
        Prize result = Prize.matchPrize(4, false);
        assertThat(result).isEqualTo(Prize.FOUR_MATCH);
    }

    @Test
    @DisplayName("matchPrize 테스트 - matchCount가 3일때")
    public void matchPrize3Numbers() {
        Prize result = Prize.matchPrize(3, false);
        assertThat(result).isEqualTo(Prize.THREE_MATCH);
    }

    @Test
    @DisplayName("matchPrize 테스트 - matchCount가 없을때")
    public void matchPrizeNoMatch() {
        Prize result = Prize.matchPrize(0, false);
        assertThat(result).isNull();
    }
}