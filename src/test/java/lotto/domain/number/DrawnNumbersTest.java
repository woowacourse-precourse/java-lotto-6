package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawnNumbersTest {
    Lotto winningNumbers;

    @BeforeEach
    void setUp() {
        Set<Number> numbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(Number::new)
                .collect(Collectors.toSet());

        winningNumbers = new Lotto(numbers);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
    @Test
    void createDrawnNumbersByDuplicatedBonusNumber() {
        Number bonusNumber = new Number(1);

        assertThatThrownBy(() -> new DrawnNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countMatches_and_isBonusNumberIn() {
        Number bonusNumber = new Number(7);

        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers, bonusNumber);

        Set<Number> numbers = Stream.of(2, 3, 4, 5, 6, 7)
                .map(Number::new)
                .collect(Collectors.toSet());

        Lotto lotto = new Lotto(numbers);

        int matchCount = drawnNumbers.countMatches(lotto);
        boolean bonus = drawnNumbers.isBonusNumberIn(lotto);

        assertThat(matchCount).isEqualTo(5);
        assertThat(bonus).isTrue();
    }
}