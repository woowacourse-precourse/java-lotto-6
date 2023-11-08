package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.exception.DuplicatedNumberException;
import lotto.exception.OutOfRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("올바른 보너스 번호")
    @CsvSource({"7", "12", "22", "45"})
    @ParameterizedTest
    void createWinningLotto(String input) {
        new WinningLotto(lotto, Integer.parseInt(input));
    }

    @DisplayName("보너스 번호가 1부터 45까지가 아니면 예외가 발생한다.")
    @CsvSource({"-1", "0", "46", "1000"})
    @ParameterizedTest
    void createWinningLottoNotInRange(String input) {
        assertThatThrownBy(() -> new WinningLotto(lotto, Integer.parseInt(input))).isInstanceOf(
                OutOfRangeException.class);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @CsvSource({"1", "2", "3", "4", "5", "6"})
    @ParameterizedTest
    void createWinningLottoByDuplicatedNumber(String input) {
        assertThatThrownBy(() -> new WinningLotto(lotto, Integer.parseInt(input))).isInstanceOf(
                DuplicatedNumberException.class);
    }
}