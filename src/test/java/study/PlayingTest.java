package study;

import lotto.model.Lotto;
import lotto.model.Playing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PlayingTest {

    @BeforeEach
    public void setUp(){
        Playing.lottos.clear();
        Playing.winningStatistics = Arrays.asList(0, 0, 0, 0, 0);
    }

    @Test
    public void testUpdateLottos() {
        // Arrange
        int lottoCnt = 6;

        // Act
        Playing.updateLottos(lottoCnt);

        // Assert
        Assertions.assertEquals(lottoCnt, Playing.lottos.size());
    }

    @Test
    public void testCompareLottosAndWinningNumbers() {
        // Arrange
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonus = 7;
        int lottoCnt = 3;
        Playing.updateLottos(lottoCnt);

        // Act
        Playing.compareLottosAndWinningNumbers(winningNumbers, bonus);

        // Assert
        for (Lotto lotto : Playing.lottos) {
            Assertions.assertTrue(lotto.getCorrectLottoCnt() >= 0 && lotto.getCorrectLottoCnt() <= 6);
            Assertions.assertTrue(lotto.isBonus() == true || lotto.isBonus() == false);
        }
    }

}
