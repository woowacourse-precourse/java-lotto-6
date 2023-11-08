package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @Test
    @DisplayName("6개 번호 일치시 FIRST 반환")
    public void testValueOfFirst() {
        LottoRank rank = LottoRank.valueOf(6, false);
        assertEquals(LottoRank.FIRST, rank, "6개 번호가 일치할 때는 FIRST 등수를 반환해야 합니다.");
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호 일치시 SECOND 반환")
    public void testValueOfSecondWithBonus() {
        LottoRank rank = LottoRank.valueOf(5, true);
        assertEquals(LottoRank.SECOND, rank, "5개 번호와 보너스 번호가 일치할 때는 SECOND 등수를 반환해야 합니다.");
    }

    @Test
    @DisplayName("5개 번호만 일치시 THIRD 반환")
    public void testValueOfThirdWithoutBonus() {
        LottoRank rank = LottoRank.valueOf(5, false);
        assertEquals(LottoRank.THIRD, rank, "5개 번호만 일치할 때는 THIRD 등수를 반환해야 합니다.");
    }

    @Test
    @DisplayName("4개 번호 일치시 FOURTH 반환")
    public void testValueOfFourth() {
        LottoRank rank = LottoRank.valueOf(4, false);
        assertEquals(LottoRank.FOURTH, rank, "4개 번호가 일치할 때는 FOURTH 등수를 반환해야 합니다.");
    }

    @Test
    @DisplayName("3개 번호 일치시 FIFTH 반환")
    public void testValueOfFifth() {
        LottoRank rank = LottoRank.valueOf(3, false);
        assertEquals(LottoRank.FIFTH, rank, "3개 번호가 일치할 때는 FIFTH 등수를 반환해야 합니다.");
    }

    @Test
    @DisplayName("일치하는 번호가 없을 경우 NONE 반환")
    public void testValueOfNone() {
        LottoRank rank = LottoRank.valueOf(0, false);
        assertEquals(LottoRank.NONE, rank, "일치하는 번호가 없을 경우 NONE 등수를 반환해야 합니다.");
    }
}
