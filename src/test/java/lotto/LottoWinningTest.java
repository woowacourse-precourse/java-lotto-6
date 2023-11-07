package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.LottoWinning;
import lotto.exceptions.DuplicateException;
import lotto.exceptions.InvalidLengthException;
import lotto.exceptions.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningTest {
    @DisplayName("중복된 값이 들어오면 예외를 발생시킨다")
    @Test
    void checkDuplicate() {
        assertThatThrownBy(() -> new LottoWinning(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(DuplicateException.class);
    }

    @DisplayName("길이가 6이 아니면 예외를 발생시킨다")
    @Test
    void checkLength() {
        assertThatThrownBy(() -> new LottoWinning(List.of()))
                .isInstanceOf(InvalidLengthException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(1)))
                .isInstanceOf(InvalidLengthException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(1, 2)))
                .isInstanceOf(InvalidLengthException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(1, 2, 3)))
                .isInstanceOf(InvalidLengthException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(1, 2, 3, 4)))
                .isInstanceOf(InvalidLengthException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(InvalidLengthException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InvalidLengthException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(1, 2, 3, 4, 5, 6, 7, 8)))
                .isInstanceOf(InvalidLengthException.class);
    }

    @DisplayName("올바른 범위의 값이 들어오지 않는다면 예외를 발생시킨다")
    @Test
    void checkNumber() {
        assertThatThrownBy(() -> new LottoWinning(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(InvalidNumberException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(41, 42, 43, 44, 45, 46)))
                .isInstanceOf(InvalidNumberException.class);
        assertThatThrownBy(() -> new LottoWinning(List.of(-1, -2, -3, -4, -5, -6)))
                .isInstanceOf(InvalidNumberException.class);
    }
}
