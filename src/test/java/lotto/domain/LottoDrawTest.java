package lotto.domain;

import lotto.domain.number.ManualNumberStrategy;
import lotto.domain.number.NumberStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoDrawTest {
    private LottoDraw lottoDraw;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 10)));
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        bonusNumber = 7;

        lottoDraw = new LottoDraw(lottoTickets);
    }

    @Test
    void testExtractResult() {
        NumberStrategy numberStrategy = new ManualNumberStrategy("1,2,3,4,5,6");

        Map<LottoResult, Integer> resultCounts = lottoDraw.extractResult(numberStrategy, bonusNumber);

        assertEquals(0, resultCounts.get(LottoResult.MATCH_3));
        assertEquals(0, resultCounts.get(LottoResult.MATCH_4));
        assertEquals(1, resultCounts.get(LottoResult.MATCH_5));
        assertEquals(1, resultCounts.get(LottoResult.MATCH_5_WITH_BONUS));
        assertEquals(1, resultCounts.get(LottoResult.MATCH_6));

    }
}