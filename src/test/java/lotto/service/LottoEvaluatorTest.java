package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoEvaluatorTest {
    @Test
    @DisplayName("모든 로또 번호가 일치하는 경우 1등으로 평가되어야 한다")
    void shouldEvaluateFirstPrizeForAllMatchingNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        Lotto matchingLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> purchasedLotto = List.of(matchingLotto);

        LottoEvaluator evaluator = new LottoEvaluator();
        Map<Prize, Integer> results = evaluator.evaluate(purchasedLotto, winningNumbers);

        assertThat(results.get(Prize.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개의 번호와 보너스 번호가 일치하는 경우 2등으로 평가되어야 한다")
    void shouldEvaluateSecondPrizeForFivePlusBonusMatchingNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto secondPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Lotto> purchasedLotto = List.of(secondPrizeLotto);

        LottoEvaluator evaluator = new LottoEvaluator();
        Map<Prize, Integer> results = evaluator.evaluate(purchasedLotto, winningNumbers);

        assertThat(results.get(Prize.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("보너스 번호를 포함하지 않고 5개의 번호가 일치하는 경우 3등으로 평가되어야 한다")
    void shouldEvaluateThirdPrizeForFiveMatchingNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto thirdPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        List<Lotto> purchasedLotto = List.of(thirdPrizeLotto);

        LottoEvaluator evaluator = new LottoEvaluator();
        Map<Prize, Integer> results = evaluator.evaluate(purchasedLotto, winningNumbers);

        assertThat(results.get(Prize.THIRD)).isEqualTo(1);
    }
}