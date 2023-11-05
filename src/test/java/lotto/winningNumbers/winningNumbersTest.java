package lotto.winningNumbers;

import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class winningNumbersTest {
    @Test
    void validate_1에서_45_사이의_중복_없는_6자리는_참이다() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        assertThat(winningNumbers.getNumbers()).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void validate_중복이_존재하면_거짓을_반환한다() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new WinningNumbers(List.of(3,3,3,3,3,3)));
    }

    @Test
    void validate_6자리가_아니면_거짓을_반환한다() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new WinningNumbers(List.of(1,2,3)));
    }
    @Test
    void validate_범위를_벗어나면_거짓을_반환한다() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new WinningNumbers(List.of(0,3,40,80,100,22)));
    }
}
