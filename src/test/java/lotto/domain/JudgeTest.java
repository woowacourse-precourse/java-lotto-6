package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Judge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JudgeTest {
    @DisplayName("자동 숫자에 보너스 숫자가 포함되었는지 확인하는 메서드를 테스트한다.")
    @Test
    void compareBonusWithRandomNumbers() {
        // given
        Lotto randomNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoBonus bonus = new LottoBonus(3);

        // when
        boolean hasBonus = Judge.compareBonusNumber(randomNumbers, bonus);

        // then
        assertThat(hasBonus).isEqualTo(true);
    }

    @DisplayName("자동 숫자와 당첨 숫자의 매칭되는 개수를 리턴하는 메서드를 테스트한다.")
    @Test
    void compareWinningNumbersWithRandomNumbers() {
        // given
        int answer = 3;
        Lotto randomNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(Arrays.asList(2, 3, 5, 7, 8, 9));

        // when
        int matchCount = Judge.compareWinningNumbers(winningNumbers, randomNumbers);

        // then
        assertThat(matchCount).isEqualTo(answer);
    }
}
