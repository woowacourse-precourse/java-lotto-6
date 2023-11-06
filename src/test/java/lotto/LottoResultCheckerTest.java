package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.Result.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCheckerTest {
    @DisplayName("로또 번호와 당첨 번호를 비교해 결과를 반환한다.")
    @Test
    public void check() throws Exception {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningLotto);
        Result result = lottoResultChecker.check(lotto);

        assertThat(result).isEqualTo(SECOND_PRIZE);
    }
    @DisplayName("로또 리스트와 당첨 번호를 비교해 결과 리스트를 반환한다.")
    @Test
    public void getResults() throws Exception {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(11, 22, 33, 44, 5, 45));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto1, lotto2, lotto3));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningLotto);
        List<Result> results = lottoResultChecker.getResults(lottos);

        assertThat(results.toArray()).containsExactly(FIRST_PRIZE, SECOND_PRIZE, NO_PRIZE);
    }
}