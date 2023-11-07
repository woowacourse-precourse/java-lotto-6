package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("당첨 번호가 중복되면 null이 반환된다.")
    @Test
    void getNullByDuplicateNumbers() {
        WinningNumbers actual = WinningNumbers.from(List.of(1, 1, 2, 3, 4, 5));
        assertThat(actual).isEqualTo(null);
    }

    @DisplayName("당첨 번호가 6자리가 아니면 null이 반환된다.")
    @Test
    void getNullByFiveDigit() {
        WinningNumbers actual = WinningNumbers.from(List.of(1, 2, 3, 4, 5));
        assertThat(actual).isEqualTo(null);
    }

    @DisplayName("당첨 번호가 1~45 사이 숫자가 아니면 null이 반환된다.")
    @Test
    void getNullByNotBetweenStartAndEndInclusive() {
        WinningNumbers actual = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 46));
        assertThat(actual).isEqualTo(null);
    }

    @DisplayName("당첨 번호가 1~45 사이 숫자이고, 중복되지 않는 6자리라면 해당 번호의 WinningNumbers가 생성된다.")
    @Test
    void getWinningNumbers() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = WinningNumbers.from(expected);
        List<Integer> actual = winningNumbers.getWinningNumbers();
        assertThat(actual).isEqualTo(expected);
    }
}
