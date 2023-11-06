package lotto.model;

import java.util.Set;
import lotto.controller.handler.BonusNumberHandler;
import lotto.controller.handler.WinningNumberHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    private PrizeNumbers prizeNumbers;

    int bonusNumber;

    @BeforeEach
    void setUp() {
        String inputWinningNumbers = "1,2,10,29,18,6";
        WinningNumberHandler winningNumberHandler = new WinningNumberHandler(inputWinningNumbers);
        winningNumberHandler.handle();
        Set<Integer> sequencedNumbers = winningNumberHandler.getHandledResult();

        BonusNumberHandler bonusNumberHandler = new BonusNumberHandler("4");
        bonusNumberHandler.handle();
        bonusNumber = bonusNumberHandler.getHandledResult();
        prizeNumbers = new PrizeNumbers(sequencedNumbers, bonusNumber);
    }

    @Test
    void testIsMatchedWithCorrectCase() {
        int[] sortedWinningNumbers = {1, 2, 10, 29, 18, 6};

        for (int sequence = 0; sequence < sortedWinningNumbers.length; sequence++) {
            boolean isMatched = prizeNumbers.isMatched(sortedWinningNumbers[sequence]);
            Assertions.assertThat(isMatched).isTrue();
        }

    }

    @Test
    void testIsMatchedWithIncorrectCase() {
        boolean isMatched = prizeNumbers.isMatched(1);
        Assertions.assertThat(isMatched).isFalse();

        isMatched = prizeNumbers.isMatched(5);
        Assertions.assertThat(isMatched).isFalse();
    }

    @Test
    void testIsBonusNumberWithBonusNumber() {
        boolean isBonusNumber = prizeNumbers.isBonusNumber(bonusNumber);
        Assertions.assertThat(isBonusNumber).isTrue();
    }

    @Test
    void testIsBonusNumberWithNonBonusNumber() {
        boolean isBonusNumber = prizeNumbers.isBonusNumber(bonusNumber + 1);
        Assertions.assertThat(isBonusNumber).isFalse();
    }
}