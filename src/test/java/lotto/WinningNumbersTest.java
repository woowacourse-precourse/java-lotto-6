package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void initialize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> winningLottoNumbers = new ArrayList<>(List.of(new Lotto(numbers)));
        winningNumbers = new WinningNumbers(winningLottoNumbers);
    }

    @DisplayName("당첨 번호와 발행된 로또 번호를 비교해 일치하는 수를 반환한다.")
    @Test
    void compareWithLottoThenReturnUserMatchedCount() {
        Lotto lotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        int userMatchedCount = winningNumbers.compareWith(lotto);

        assertThat(userMatchedCount).isEqualTo(2);
    }
}