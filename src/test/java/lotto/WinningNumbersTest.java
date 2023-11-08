package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("당첨번호가 범위를 벗어나면 예외 발생")
    @Test
    public void 당첨번호_범위를_벗어나는_경우_예외_발생_여부_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @DisplayName("당첨번호가 중복되면 예외 발생")
    @Test
    public void 당첨번호_중복되는_경우_예외_발생_여부_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @DisplayName("당첨번호 개수가 6개 이상이면 예외 발생")
    @Test
    public void 당첨번호_개수_유효성_테스트_6개_이상() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @DisplayName("당첨번호 개수가 6개 이하이면 예외 발생")
    @Test
    public void 당첨번호_개수_유효성_테스트_6개_이하() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers));
    }

    @DisplayName("유효한 당첨번호가 생성되면 예외가 발생하지 않음")
    @Test
    public void 유효한_당첨번호의_경우_예외_발생여부_테스트() {
        List<Integer> winningNumbers = Arrays.asList(10, 15, 20, 22, 30, 41);
        Assertions.assertDoesNotThrow(() -> new WinningNumbers(winningNumbers));
    }
}
