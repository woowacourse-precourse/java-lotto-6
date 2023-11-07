package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.util.exception.input.DuplicationNumberException;
import lotto.util.exception.input.NumberGreaterException;
import lotto.util.exception.input.NumbersNegativeException;
import lotto.util.exception.input.NumbersNullException;
import lotto.util.exception.input.WinningNumbersLengthMatchException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void contains() {
        boolean result = winningNumbers.contains(1);
        assertThat(result).isTrue();
    }

    @Test
    void 예외_최대_숫자_테스트() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,2,3,46,5,6"))
                .isInstanceOf(NumberGreaterException.class);
    }

    @Test
    void 예외_입력_문자_음수_테스트() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("-1,2,3,4,5,6"))
                .isInstanceOf(NumbersNegativeException.class);
    }

    @Test
    void 예외_입력_문자_개_수_테스트() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(WinningNumbersLengthMatchException.class);
    }

    @Test
    void 예외_중복_문자_입력_테스트() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,1,2,3,4,5"))
                .isInstanceOf(DuplicationNumberException.class);
    }

    @Test
    void 예외_NUll_입력_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(null))
                .isInstanceOf(NumbersNullException.class);
    }
}