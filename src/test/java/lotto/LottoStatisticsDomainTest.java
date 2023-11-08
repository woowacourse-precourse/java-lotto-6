package lotto;

import lotto.domain.LottoStatisticsDomain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoStatisticsDomainTest {
    private static LottoStatisticsDomain lottoStatisticsDomain;

    @DisplayName("당첨 번호를 모두 맞춘 경우와 보너스 번호가 있는 경우를 구별")
    @Test
    void createSecondWinnerAndFirstWinner() {
        List<Integer> winningLottoNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Lotto> purchaseLotto;
        purchaseLotto = new ArrayList<>(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 5)),
                new Lotto(List.of(1, 2, 3, 4, 8, 7)),
                new Lotto(List.of(1, 2, 3, 9, 8, 7)),
                new Lotto(List.of(1, 2, 10, 9, 8, 7)),
                new Lotto(List.of(1, 11, 10, 9, 8, 7)),
                new Lotto(List.of(12, 11, 10, 9, 8, 7))
        ));

        lottoStatisticsDomain = new LottoStatisticsDomain(purchaseLotto, winningLottoNumber);
        List<Integer> statisticsResult = lottoStatisticsDomain.lottoStatistics();
        assertEquals(Arrays.asList(6, -5, 5, 4, 3, 2, 1, 0), statisticsResult);
    }
}
