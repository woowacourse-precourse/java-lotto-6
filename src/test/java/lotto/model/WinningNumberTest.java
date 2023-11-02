package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    static final int WINNING_NUMBER_SIZE = 7;
    static final int WINNING_NUMBER_MIN = 1;
    static final int WINNING_NUMBER_MAX = 45;

    @Test
    @DisplayName("당첨 번호 생성 테스트")
    void createWinningNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = winningNumber.getNumbers();

        assertThat(numbers).hasSize(WINNING_NUMBER_SIZE);
        for (Integer number : numbers) {
            assertThat(number).isBetween(WINNING_NUMBER_MIN, WINNING_NUMBER_MAX);
        }
        assertThat(new HashSet<>(numbers).size()).isEqualTo(WINNING_NUMBER_SIZE);
    }
}