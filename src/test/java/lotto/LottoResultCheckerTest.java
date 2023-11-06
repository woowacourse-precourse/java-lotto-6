package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCheckerTest {
    @DisplayName("로또 번호와 당첨 번호를 비교해 결과를 반환한다.")
    @Test
    public void check() throws Exception {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningLotto);
        Result result = lottoResultChecker.check(lotto);

        assertThat(result).isEqualTo(Result.SECOND_PRIZE);
    }
}