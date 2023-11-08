package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningResultTest {
    private static final LottoNumbers WINNING_NUMBER = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6), 11);
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult();
    }

    @ParameterizedTest
    @CsvSource({"SIXTH,3", "FIFTH,0", "FOURTH,0", "THIRD,1", "SECOND,1", "FIRST,1"})
    void countNumberOfWinning_메서드로_등수별_당첨_갯수를_확인(String prize, int expected) {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(12, 13, 14, 15, 16, 17)));
        lottoTickets.add(new Lotto(List.of(6, 7, 8, 9, 10, 11)));
        lottoTickets.add(new Lotto(List.of(5, 6, 7, 8, 9, 10)));
        lottoTickets.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottoTickets.add(new Lotto(List.of(2, 3, 4, 5, 6, 11)));
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Map<PrizeCategory, Integer> actual = winningResult.countNumberOfWinning(lottoTickets, WINNING_NUMBER);

        assertThat(actual.get(PrizeCategory.valueOf(prize))).isEqualTo(expected);
    }

    @Test
    void getTotalPrizeMoney_메서드로_당첨된_총_상금_반환() {
        Map<PrizeCategory, Integer> map = new HashMap<>();
        map.put(PrizeCategory.LOSE, 1);
        map.put(PrizeCategory.FIFTH, 2);
        map.put(PrizeCategory.FOURTH, 0);
        map.put(PrizeCategory.THIRD, 1);
        map.put(PrizeCategory.SECOND, 1);
        map.put(PrizeCategory.FIRST, 0);

        long actual = winningResult.getTotalPrizeMoney(map);

        assertThat(actual).isEqualTo(31510000);
    }

    @Test
    void getRateOfReturn_메서드로_구입금액_대비_총_상금의_수익률을_반환() {
        long purchaseAmount = 8000;
        long totalPrizeMoney = 5000;

        double actual = winningResult.getRateOfReturn(purchaseAmount, totalPrizeMoney);

        assertThat(actual).isEqualTo(62.5);
    }

    @Test
    void getRateOfReturn_메서드로_로또_100장을_구입해_모두_1등이_당첨되었을_때_수익률을_반환() {
        long purchaseAmount = 100000;
        long totalPrizeMoney = 200000000000L;

        double actual = winningResult.getRateOfReturn(purchaseAmount, totalPrizeMoney);

        assertThat(actual).isEqualTo(200000000.0);
    }

}
