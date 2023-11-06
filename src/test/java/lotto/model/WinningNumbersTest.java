package lotto.model;

import java.util.Map;
import lotto.controller.handler.BonusNumberHandler;
import lotto.controller.handler.WinningNumberHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    int bonusNumber;

    @BeforeEach
    void setUp() {
        String inputWinningNumbers = "1,2,10,29,18,6";
        WinningNumberHandler winningNumberHandler = new WinningNumberHandler(inputWinningNumbers);
        winningNumberHandler.handle();
        Map<Integer, Integer> sequencedNumbers = winningNumberHandler.getHandledResult();

        BonusNumberHandler bonusNumberHandler = new BonusNumberHandler("4");
        bonusNumberHandler.handle();
        bonusNumber = bonusNumberHandler.getHandledResult();
        winningNumbers = new WinningNumbers(sequencedNumbers, bonusNumber);
    }

    @Test
    void testIsMatchedWithCorrectCase() {
        int[] sortedWinningNumbers = {1, 2, 10, 29, 18, 6};

        for (int sequence = 0; sequence < sortedWinningNumbers.length; sequence++) {
            boolean isMatched = winningNumbers.isMatched(sortedWinningNumbers[sequence], sequence);
            Assertions.assertThat(isMatched).isTrue();
        }

    }

    @Test
    void testIsMatchedWithIncorrectCase() {
        boolean isMatched = winningNumbers.isMatched(1, 1);
        Assertions.assertThat(isMatched).isFalse();

        isMatched = winningNumbers.isMatched(5, 1);
        Assertions.assertThat(isMatched).isFalse();
    }

    @Test
    void testIsBonusNumberWithBonusNumber() {
        boolean isBonusNumber = winningNumbers.isBonusNumber(bonusNumber);
        Assertions.assertThat(isBonusNumber).isTrue();
    }

    @Test
    void testIsBonusNumberWithNonBonusNumber() {
        boolean isBonusNumber = winningNumbers.isBonusNumber(bonusNumber + 1);
        Assertions.assertThat(isBonusNumber).isFalse();
    }
}