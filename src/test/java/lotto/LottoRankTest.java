package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @Test
    @DisplayName("6개 번호가 일치하면 FIRST 등수를 반환해야 한다")
    public void testFirstRank() {
        assertEquals(LottoRank.FIRST, LottoRank.fromMatchCount(6));
    }

    @Test
    @DisplayName("5개 번호가 일치하면 SECOND 등수를 반환해야 한다")
    public void testSecondRank() {
        assertEquals(LottoRank.SECOND, LottoRank.fromMatchCount(5));
    }

    @Test
    @DisplayName("4개 번호가 일치하면 THIRD 등수를 반환해야 한다")
    public void testThirdRank() {
        assertEquals(LottoRank.THIRD, LottoRank.fromMatchCount(4));
    }

    @Test
    @DisplayName("3개 번호가 일치하면 FOURTH 등수를 반환해야 한다")
    public void testFourthRank() {
        assertEquals(LottoRank.FOURTH, LottoRank.fromMatchCount(3));
    }

    @Test
    @DisplayName("2개 번호가 일치하면 FIFTH 등수를 반환해야 한다")
    public void testFifthRank() {
        assertEquals(LottoRank.FIFTH, LottoRank.fromMatchCount(2));
    }

    @Test
    @DisplayName("일치하는 번호가 없으면 NONE 등수를 반환해야 한다")
    public void testNoMatch() {
        assertEquals(LottoRank.NONE, LottoRank.fromMatchCount(0));
    }
}
