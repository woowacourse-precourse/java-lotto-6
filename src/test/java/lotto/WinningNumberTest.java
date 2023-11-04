package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @Test
    void 숫자6개_보너스1개_생성() {
        WinningNumber winningNumber = WinningNumber.getInstance();
        List<Integer> numbers = winningNumber.getNumbers();

        assertThat(numbers.size()).isEqualTo(6);
        assertThat(winningNumber.getBonusNumber()).isNotNull();
    }

    @Test
    void 중복되지않는숫자7개_생성() {
        WinningNumber winningNumber = WinningNumber.getInstance();
        List<Integer> numbers = winningNumber.getNumbers();
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        numbersSet.add(winningNumber.getBonusNumber());

        assertThat(numbersSet.size()).isEqualTo(7);
    }
}
