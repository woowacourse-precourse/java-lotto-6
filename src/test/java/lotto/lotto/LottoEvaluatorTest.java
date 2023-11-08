package lotto.lotto;

import static lotto.global.Constant.LOTTO_NO_WIN_RANK;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoEvaluatorTest {
    LottoEvaluator lottoEvaluator = new LottoEvaluator();

    @DisplayName("6개의 숫자가 당첨 번호와 모두 일치하는 로또는 1등이다.")
    @Test
    void evaluateLottoFirstRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Integer rank = lottoEvaluator.evaluateLottoRank(lotto, winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(1);
    }

    @DisplayName("5개의 숫자가 당첨 번호와 일치하고 나머지 숫자가 보너스 숫자와 일치하는 로또는 2등이다.")
    @Test
    void evaluateLottoSecondRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Integer rank = lottoEvaluator.evaluateLottoRank(lotto, winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(2);
    }

    @DisplayName("5개의 숫자는 당첨 번호와 일치하지만 나머지 숫자가 보너스 숫자가 다른 로또는 3등이다.")
    @Test
    void evaluateLottoThirdRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Integer rank = lottoEvaluator.evaluateLottoRank(lotto, winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(3);
    }

    @DisplayName("4개의 숫자가 당첨 번호와 일치하는 로또는 4등이다.")
    @Test
    void evaluateLottoFourthRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Integer rank = lottoEvaluator.evaluateLottoRank(lotto, winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(4);
    }

    @DisplayName("3개의 숫자가 당첨 번호와 일치하는 로또는 5등이다.")
    @Test
    void evaluateLottoFifthRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Integer rank = lottoEvaluator.evaluateLottoRank(lotto, winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(5);
    }

    @DisplayName("3개의 숫자도 일치하지 않는 로또는 당첨되지 않은 로또이다.")
    @Test
    void evaluateLottoZeroRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Integer rank = lottoEvaluator.evaluateLottoRank(lotto, winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(LOTTO_NO_WIN_RANK.getNumber());
    }
}