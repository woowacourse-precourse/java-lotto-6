package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinCountTest {

    @Test
    public void testCalculateWinCount() {
        // Arrange
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // Act
        int result = WinCount.calculateWinCount(userNumbers, winNumbers, bonusNumber);

        // Assert
        assertEquals(7, result);
    }
}