package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PrizeCalculatorTest {
    private Lotto winningLotto;
    private int bonusNumber;
    private PrizeCalculator calculator;
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        calculator = new PrizeCalculator(winningLotto, bonusNumber);
    }

    @Test
    @DisplayName("로또를 생성한 개수와, 상금 결과의 개수가 동일해야 한다.")
    void prizeCount() {
        int count = 5;
        int purchaseAmount = 10000; // 구매 금액 예시
        LottoTicket lottoTicket = new LottoTicket(count);

        LottoResult result = calculator.evaluateLotto(lottoTicket, purchaseAmount);
        EnumMap<Prize, Integer> results = result.getPrizeResults();

        int totalPrizesCount = results.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(count, totalPrizesCount);
    }

    @Test
    @DisplayName("당첨번호와 6개가 일치하면 1등이다.")
    void firstPrize() {
        int purchaseAmount = 2000;
        long expectedPrize = Prize.FIRST.getPrize();
        double expectedEarnRate = ((double) expectedPrize / purchaseAmount) * 100;

        lottoTicket = mock(LottoTicket.class);
        when(lottoTicket.getLottoTickets())
                .thenReturn(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        LottoResult result = calculator.evaluateLotto(lottoTicket, purchaseAmount);
        assertEquals(1, result.getPrizeResults().getOrDefault(Prize.FIRST, 0));
        assertEquals(expectedEarnRate, result.getEarnRate());
    }

    @Test
    @DisplayName("당첨번호와 5개가 일치하고 보너스 번호가 일치하면 2등이다.")
    void secondPrize() {
        int purchaseAmount = 2000;
        long expectedPrize = Prize.SECOND.getPrize();
        double expectedEarnRate = ((double) expectedPrize / purchaseAmount) * 100;

        lottoTicket = mock(LottoTicket.class);
        when(lottoTicket.getLottoTickets())
                .thenReturn(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))));

        LottoResult result = calculator.evaluateLotto(lottoTicket, purchaseAmount);
        assertEquals(1, result.getPrizeResults().getOrDefault(Prize.SECOND, 0));
        assertEquals(expectedEarnRate, result.getEarnRate());
    }

    @Test
    @DisplayName("당첨번호와 5개가 일치하면 3등이다.")
    void thirdPrize() {
        int purchaseAmount = 2000;
        long expectedPrize = Prize.THIRD.getPrize();
        double expectedEarnRate = ((double) expectedPrize / purchaseAmount) * 100;

        lottoTicket = mock(LottoTicket.class);
        when(lottoTicket.getLottoTickets())
                .thenReturn(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))));

        LottoResult result = calculator.evaluateLotto(lottoTicket, purchaseAmount);
        assertEquals(1, result.getPrizeResults().getOrDefault(Prize.THIRD, 0));
        assertEquals(expectedEarnRate, result.getEarnRate());
    }

    @Test
    @DisplayName("당첨번호와 4개가 일치하면 4등이다.")
    void fourthPrize() {
        int purchaseAmount = 2000;
        long expectedPrize = Prize.FOURTH.getPrize();
        double expectedEarnRate = ((double) expectedPrize / purchaseAmount) * 100;

        lottoTicket = mock(LottoTicket.class);
        when(lottoTicket.getLottoTickets())
                .thenReturn(List.of(new Lotto(List.of(1, 2, 3, 4, 7, 8))));

        LottoResult result = calculator.evaluateLotto(lottoTicket, purchaseAmount);
        assertEquals(1, result.getPrizeResults().getOrDefault(Prize.FOURTH, 0));
        assertEquals(expectedEarnRate, result.getEarnRate());
    }

    @Test
    @DisplayName("당첨번호와 3개가 일치하면 5등이다.")
    void fifthPrize() {
        int purchaseAmount = 2000;
        long expectedPrize = Prize.FIFTH.getPrize();
        double expectedEarnRate = ((double) expectedPrize / purchaseAmount) * 100;

        lottoTicket = mock(LottoTicket.class);
        when(lottoTicket.getLottoTickets())
                .thenReturn(List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9))));

        LottoResult result = calculator.evaluateLotto(lottoTicket, purchaseAmount);
        assertEquals(1, result.getPrizeResults().getOrDefault(Prize.FIFTH, 0));
        assertEquals(expectedEarnRate, result.getEarnRate());
    }

    @Test
    @DisplayName("당첨번호와 2개 이하로 일치하면 상금은 없다.")
    void nonePrize() {
        int purchaseAmount = 2000;
        double expectedEarnRate = 0.0;

        lottoTicket = mock(LottoTicket.class);
        when(lottoTicket.getLottoTickets())
                .thenReturn(List.of(new Lotto(List.of(1, 2, 7, 8, 9, 10))));

        LottoResult result = calculator.evaluateLotto(lottoTicket, purchaseAmount);
        assertEquals(1, result.getPrizeResults().getOrDefault(Prize.NONE, 0));
        assertEquals(expectedEarnRate, result.getEarnRate());
    }
}
