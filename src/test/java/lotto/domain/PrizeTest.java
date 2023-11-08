package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("6개의 번호가 일치하면 1등에 당첨된다.")
    @Test
    public void shouldReturnFirstPrize() {
        assertEquals(Prize.FIRST, Prize.determinePrize(6, false));
    }

    @DisplayName("5개의 번호가 일치하고, 보너스 번호가 일치하면 2등에 당첨된다.")
    @Test
    public void shouldReturnSecondPrize() {
        assertEquals(Prize.SECOND, Prize.determinePrize(5, true));
    }

    @DisplayName("5개의 번호가 일치하면 3등에 당첨된다.")
    @Test
    public void shouldReturnThirdPrize() {
        assertEquals(Prize.THIRD, Prize.determinePrize(5, false));
    }

    @DisplayName("4개의 번호가 일치하면 4등에 당첨된다.")
    @Test
    public void shouldReturnFourthPrize() {
        assertEquals(Prize.FOURTH, Prize.determinePrize(4, false));
    }

    @DisplayName("3개의 번호가 일치하면 5등에 당첨된다.")
    @Test
    public void shouldReturnFifthPrize() {
        assertEquals(Prize.FIFTH, Prize.determinePrize(3, false));
    }
}