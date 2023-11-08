package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {

    @DisplayName("당첨 번호 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoMachineByInvalidSize() {
        assertThatThrownBy(() -> LottoMachine.draw(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 1, 2, 3, 4, 5:6", "1, 2, 3, 4, 5, 6:46"}, delimiter = ':')
    void createLottoMachineByInvalidNumber(String inputNumber, int bonusNumber) {
        List<Integer> numbers = Stream.of(inputNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        assertThatThrownBy(() -> LottoMachine.draw(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호는 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:6", "1, 2, 3, 4, 5, 6:1"}, delimiter = ':')
    void createLottoMachineByDuplicatedNumber(String inputNumber, int bonusNumber) {
        List<Integer> numbers = Stream.of(inputNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        assertThatThrownBy(() -> LottoMachine.draw(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
