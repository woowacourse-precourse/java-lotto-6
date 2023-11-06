package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    public void 당첨번호가_범위를_벗어났을_때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @Test
    public void 당첨번호가_중복되었을_때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @Test
    public void 당첨번호_개수가_6개_이상일_때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @Test
    public void 당첨번호_개수가_6개_이하일_때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @Test
    public void 유효한_당첨번호_테스트() {
        List<Integer> winningNumbers = Arrays.asList(10, 15, 20, 22, 30, 41);
        Assertions.assertDoesNotThrow(() -> new WinningNumbers(winningNumbers));
    }
}
