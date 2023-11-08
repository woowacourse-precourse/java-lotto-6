package lotto.model;

import lotto.model.WinningCriteria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WinningCriteriaTest {
    @Test
    void testFirstRank() {
        WinningCriteria firstRank = WinningCriteria.FIRST;

        assertTrue(firstRank.matchNumberCount(6));
        assertFalse(firstRank.matchNumberCount(5));
    }

    @Test
    void testSecondRank() {
        WinningCriteria secondRank = WinningCriteria.SECOND;

        assertTrue(secondRank.matchNumberCount(5));
        assertFalse(secondRank.matchNumberCount(4));
    }

    @Test
    void testThirdRank() {
        WinningCriteria thirdRank = WinningCriteria.THIRD;

        assertTrue(thirdRank.matchNumberCount(5));
        assertFalse(thirdRank.matchNumberCount(4));
    }

    @Test
    void testFourthRank() {
        WinningCriteria fourthRank = WinningCriteria.FOURTH;

        assertTrue(fourthRank.matchNumberCount(4));
        assertFalse(fourthRank.matchNumberCount(3));
    }

    @Test
    void testFifthRank() {
        WinningCriteria fifthRank = WinningCriteria.FIFTH;

        assertTrue(fifthRank.matchNumberCount(3));
        assertFalse(fifthRank.matchNumberCount(2));
    }
}
