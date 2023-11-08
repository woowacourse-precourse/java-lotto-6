package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("당첨 로또 생성")
    @Test
    void setWinningNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers();
        String[] numbers = {"1", "2", "3", "4", "5", "6"};

        var winningLotto = winningNumbers.setWinningNumbers(numbers);

        assertThat(winningLotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}