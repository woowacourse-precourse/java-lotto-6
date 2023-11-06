package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {

    private final List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호에 1~45범위를 넘은 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "46", "77"})
    void createBonusNumberByOverRange(int input) {
        assertThatThrownBy(() -> new BonusNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4", "5", "6"})
    void createBonusNumberByDuplicate(int input) {
        assertThatThrownBy(() -> new BonusNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}