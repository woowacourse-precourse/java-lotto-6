package lotto.domain;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void lottos_생성자_테스트() {
        List<List<Integer>> numbers = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16, 17, 18)
        ));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));

        assertNotNull(lottos);

        List<List<Integer>> lottoNumbers = lottos.getLottos().stream().map(Lotto::getNumbers).toList();
        assertEquals(numbers, lottoNumbers);
    }

    @Test
    void 당첨_통계_계산_테스트() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto1 = mock(Lotto.class);
        Lotto lotto2 = mock(Lotto.class);
        Lotto lotto3 = mock(Lotto.class);

        when(lotto1.getRanking(winningNumbers, bonusNumber)).thenReturn(Ranking.FIFTH);
        when(lotto2.getRanking(winningNumbers, bonusNumber)).thenReturn(Ranking.FIFTH);
        when(lotto3.getRanking(winningNumbers, bonusNumber)).thenReturn(Ranking.FIFTH);

        List<Lotto> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoNumbers.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        lottoNumbers.add(new Lotto(List.of(13, 14, 15, 16, 17, 18)));

        Lottos lottos = new Lottos(lottoNumbers);

        List<Lotto> mockLottos = lottos.getLottos();
        mockLottos.set(0, lotto1);
        mockLottos.set(1, lotto2);
        mockLottos.set(2, lotto3);

        Map<Ranking, Integer> winningStatics = lottos.calculateWinningStatistics(winningNumbers, bonusNumber);

        Map<Ranking, Integer> statics = Map.ofEntries(
                entry(Ranking.FIRST, 0),
                entry(Ranking.SECOND, 0),
                entry(Ranking.THIRD, 0),
                entry(Ranking.FOURTH, 0),
                entry(Ranking.FIFTH, 3),
                entry(Ranking.NONE, 0)
        );
        assertEquals(statics, winningStatics);
    }

    @Test
    void 당첨금_계산_테스트() {
        Lotto lotto1 = mock(Lotto.class);
        Lotto lotto2 = mock(Lotto.class);

        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        Map<Ranking, Integer> statics = Map.ofEntries(
                entry(Ranking.FIRST, 1),
                entry(Ranking.SECOND, 1),
                entry(Ranking.THIRD, 0),
                entry(Ranking.FOURTH, 0),
                entry(Ranking.FIFTH, 1),
                entry(Ranking.NONE, 0)
        );

        assertEquals(2030005000, lottos.calculateTotalPrize(statics));
    }
}
