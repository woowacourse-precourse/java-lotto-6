package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void constructor_당첨번호_생성() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(numbers);

        assertThat(winningNumber.getNumbers()).isEqualTo(numbers);
    }
}