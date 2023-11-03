package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawnNumbersTest {
    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
    @Test
    void createDrawnNumbersByDuplicatedBonusNumber() {
        Set<Number> numbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(Number::new)
                .collect(Collectors.toSet());

        Lotto winningNumbers = new Lotto(numbers);
        Number bonusNumber = new Number(1);

        assertThatThrownBy(() -> new DrawnNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}