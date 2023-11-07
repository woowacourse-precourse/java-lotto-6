package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Judge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JudgeTest {
    private static final int FIRST_PLACE_AMOUNT = 2_000_000_000;
    private static final int SECOND_PLACE_AMOUNT = 30_000_000;
    private static final int THIRD_PLACE_AMOUNT = 1_500_000;

    @DisplayName("자동 숫자에 보너스 숫자가 포함되었는지 확인하는 메서드를 테스트한다.")
    @Test
    void testCompareBonusNumber() {
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
    void testCompareWinningNumbers() {
        // given
        int answer = 3;
        Lotto randomNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(Arrays.asList(2, 3, 5, 7, 8, 9));

        // when
        int matchCount = Judge.compareWinningNumbers(winningNumbers, randomNumbers);

        // then
        assertThat(matchCount).isEqualTo(answer);
    }

    @DisplayName("당첨 금액의 총합을 계산하는 메서드를 테스트한다.")
    @Test
    void testCalculateEarnings() {
        // given
        List<Lotto> randomNumbers = new ArrayList<>();
        randomNumbers.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        randomNumbers.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        randomNumbers.add(new Lotto(List.of(2, 3, 4, 5, 6, 8)));

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonus bonus = new LottoBonus(7);

        // when
        int answer = FIRST_PLACE_AMOUNT + SECOND_PLACE_AMOUNT + THIRD_PLACE_AMOUNT;
        int totalEarnings = Judge.calculateEarnings(randomNumbers, winningNumbers, bonus);

        // then
        assertThat(totalEarnings).isEqualTo(answer);
    }

    
}
