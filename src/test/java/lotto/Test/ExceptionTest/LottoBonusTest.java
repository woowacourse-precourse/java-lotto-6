package lotto.Test.ExceptionTest;
import lotto.model.lottoResultChecker.LottoBonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LottoBonusTest {

    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = List.of(3, 12, 21, 29, 38, 45);
    }

    @Test
    @DisplayName("입력값이 비어있을 경우 예외를 발생시켜야 한다")
    void shouldThrowExceptionWhenInputIsEmpty() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> new LottoBonus(input, winningNumbers));
    }

    @Test
    @DisplayName("입력값이 숫자가 아닐 경우 예외를 발생시켜야 한다")
    void shouldThrowExceptionWhenInputIsNotNumeric() {
        String input = "abc";
        assertThrows(IllegalArgumentException.class, () -> new LottoBonus(input, winningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 1에서 45 사이가 아닐 경우 예외를 발생시켜야 한다")
    void shouldThrowExceptionWhenBonusNumberIsNotBetweenOneAndFortyFive() {
        String input = "46";
        assertThrows(IllegalArgumentException.class, () -> new LottoBonus(input, winningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외를 발생시켜야 한다")
    void shouldThrowExceptionWhenBonusNumberIsDuplicatedWithWinningNumbers() {
        String input = "12";
        assertThrows(IllegalArgumentException.class, () -> new LottoBonus(input, winningNumbers));
    }
}