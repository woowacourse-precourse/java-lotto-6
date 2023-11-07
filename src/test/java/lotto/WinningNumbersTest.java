package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("당첨번호 범위 유효성 테스트")
    @Test
    public void 당첨번호가_범위를_벗어나면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @DisplayName("당첨번호 중복되지 않는지 테스트")
    @Test
    public void 당첨번호가_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @DisplayName("당첨번호 개수 유효성 테스트_6개 이상")
    @Test
    public void 당첨번호_개수가_6개_이상이면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @DisplayName("당첨번호 개수 유효성 테스트_6개 이하")
    @Test
    public void 당첨번호_개수가_6개_이하이면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @DisplayName("유효한 당첨번호 테스트")
    @Test
    public void 유효한_당첨번호가_생성되면_예외가_발생하지_않는다() {
        List<Integer> winningNumbers = Arrays.asList(10, 15, 20, 22, 30, 41);
        Assertions.assertDoesNotThrow(() -> new WinningNumbers(winningNumbers));
    }
}
