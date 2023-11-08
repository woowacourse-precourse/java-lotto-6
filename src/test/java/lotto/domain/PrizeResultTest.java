package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeResultTest {

    @DisplayName("2등, 4등, 4등 당첨 판별 기능")
    @Test
    void secondAndFourthResult() {
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto thirdLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        List<Lotto> lottoTickets = List.of(firstLotto, secondLotto, thirdLotto);

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, 6);
        PrizeResult prizeResult = new PrizeResult(winningNumbers, lottoTickets);
        Map<Prize, Integer> winningResult = prizeResult.getWinningResult();

        assertThat(winningResult.get(Prize.SECOND)).isEqualTo(1);
        assertThat(winningResult.get(Prize.FOURTH)).isEqualTo(2);
    }

    @DisplayName("2등, 3등, 3등 당첨 판별 기능")
    @Test
    void secondAndThirdResult() {
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 3, 4, 5, 8, 9));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 4, 5, 8, 11));
        List<Lotto> lottoTickets = List.of(firstLotto, secondLotto, thirdLotto);

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, 6);
        PrizeResult prizeResult = new PrizeResult(winningNumbers, lottoTickets);
        Map<Prize, Integer> winningResult = prizeResult.getWinningResult();

        assertThat(winningResult.get(Prize.SECOND)).isEqualTo(1);
        assertThat(winningResult.get(Prize.THIRD)).isEqualTo(2);
    }
}