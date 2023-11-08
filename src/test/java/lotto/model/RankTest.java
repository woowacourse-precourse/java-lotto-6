package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("6개 번호를 맞히면 1등인지 확인하는 테스트")
    @Test
    public void testValueOfFirstRank() {
        Rank rank = Rank.valueOf(6, false);
        assertEquals(Rank.FIRST, rank);
    }

    @DisplayName("5개 번호와 보너스 번호를 맞히면 2등인지 확인하는 테스트")
    @Test
    public void testValueOfSecondRank() {
        Rank rank = Rank.valueOf(5, true);
        assertEquals(Rank.SECOND, rank);
    }

    @DisplayName("5개 번호를 맞히면 3등인지 확인하는 테스트")
    @Test
    public void testValueOfThirdRank() {
        Rank rank = Rank.valueOf(5, false);
        assertEquals(Rank.THIRD, rank);
    }

    @DisplayName("4개 번호를 맞히면 4등인지 확인하는 테스트")
    @Test
    public void testValueOfFourthRank() {
        Rank rank = Rank.valueOf(4, false);
        assertEquals(Rank.FOURTH, rank);
    }

    @DisplayName("3개 번호를 맞히면 5등인지 확인하는 테스트")
    @Test
    public void testValueOfFifthRank() {
        Rank rank = Rank.valueOf(3, false);
        assertEquals(Rank.FIFTH, rank);
    }

    @DisplayName("0개 번호를 맞히면 낫싱인지 확인하는 테스트")
    @Test
    public void testValueOfNothingRank() {
        Rank rank = Rank.valueOf(0, false);
        assertEquals(Rank.NOTHING, rank);
    }
}
