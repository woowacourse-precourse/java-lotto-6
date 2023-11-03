package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {
    WinningNumbers numbers = new WinningNumbers();

    @DisplayName("로또와 당첨 번호의 개수를 비교하는 기능")
    @Test
    void countMatchNumbers() {
        numbers.makeWinningNumber("4,12,39,43,1,17");
        numbers.makeBonusNumber("33");
        LottoCalculator calculator = new LottoCalculator(numbers);
        Lotto lotto = new Lotto(List.of(2, 3, 4, 12, 43, 45));

        assertThat(calculator.countMatchNumbers(lotto)).isEqualTo(3);
    }

    @DisplayName("당첨 번호와 보너스 번호를 함께 비교하는 기능")
    @Test
    void countMatchBonusNumbers() {
        numbers.makeWinningNumber("4,12,39,43,1,17");
        numbers.makeBonusNumber("3");
        LottoCalculator calculator = new LottoCalculator(numbers);
        Lotto lotto = new Lotto(List.of(3, 4, 12, 39, 43, 45));

        assertThat(calculator.countMatchNumbers(lotto)).isEqualTo(5);
    }
}