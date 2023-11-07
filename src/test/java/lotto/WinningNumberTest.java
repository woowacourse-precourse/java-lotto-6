package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningNumber;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @Test
    void 정답_생성_성공() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(numbers.stream().toList());
        List<Integer> winningNumberNumbers = winningNumber.getNumbers();

        assertThat(winningNumberNumbers.size()).isEqualTo(6);
        assertThat(winningNumberNumbers).isEqualTo(numbers);
    }

    @Test
    void 로또번호갯수_보다_많은_값_입력() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(numbers));
    }

    @Test
    void 로또번호갯수_보다_적은_값_입력() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(numbers));
    }

    @Test
    void 로또범위보다_큰_값_입력() {
        List<Integer> numbers = List.of(99, 2, 3, 4, 5, 48);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(numbers));
    }

    @Test
    void 로또범위보다_작은_값_입력_0() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(numbers));
    }

    @Test
    void 로또범위보다_작은_값_입력_음수() {
        List<Integer> numbers = List.of(-3, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(numbers));
    }

    @Test
    void 빈_배열_입력() {
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(new ArrayList<>()));
    }

    @Test
    void NULL_입력() {
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(null));
    }
}
