package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {

    private final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    private final LottoMatcher lottoMatcher = new LottoMatcher(winningNumbers);;

    @Test
    @DisplayName("로또 티켓과 당첨 번호의 일치 개수 확인")
    public void testCountMatchedNumbersForLottoTickets() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto lotto3 = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

        List<Lotto> lottoTickets = Arrays.asList(lotto1, lotto2, lotto3);

        List<Integer> matchedCounts = lottoMatcher.countMatchedNumbersForLottoTickets(lottoTickets);

        assertThat(matchedCounts).containsExactly(6, 3, 0);
    }
}
