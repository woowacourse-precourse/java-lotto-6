package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningValidatorTest {
    private WinningValidator winningValidator;
    private List<Integer> winningNumbers;
    private List<Integer> numbers;
    private int bonusNumber;

    @BeforeEach
    public void setUp() {
        winningValidator = new WinningValidator();
        winningNumbers = Arrays.asList(3, 6, 17, 23, 28, 40);
        numbers = Arrays.asList(4, 6, 17, 19, 23, 36);
        bonusNumber = 10;
    }

    @Test
    void 당첨_횟수_카운트_테스트() {
        int expectedMatchCount = 3;
        int actualMatchCount = winningValidator.countMatchNumbers(winningNumbers, numbers);

        assertEquals(expectedMatchCount, actualMatchCount);
    }

    @DisplayName("보너스 번호가 당첨 되지 않았으면 false 를 반환한다.")
    @Test
    void 보너스_번호_비당첨_테스트() {
        assertFalse(winningValidator.checkWinningBonusNumber(numbers, bonusNumber));
    }

    @DisplayName("보너스 번호가 당첨 되었다면 true 를 반환한다.")
    @Test
    void 보너스_번호_당첨_테스트() {
        assertTrue(winningValidator.checkWinningBonusNumber(numbers, bonusNumber));
    }
}