package lotto;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoServiceTest extends LottoService {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private LottoService lottoService;
    private List<Lotto> mockedLottos;

    @BeforeEach
    void setUp() {
        mockedLottos = Arrays.asList(mock(Lotto.class), mock(Lotto.class));
        lottoService = new LottoService();
        lottoService.setLottoTickets(mockedLottos);
    }

    @DisplayName("정상적으로 발행된 티켓")
    @Test
    void generateLottoTickets_CorrectNumberOfTickets() {

        LottoService lottoService = new LottoService();
        int purchaseAmount = 5000;

        lottoService.generateLottoTickets(purchaseAmount);
        List<Lotto> generatedTickets = lottoService.getLottoTickets();


        int expectedTicketCount = purchaseAmount / 1000;
        assertThat(generatedTickets).hasSize(expectedTicketCount);


        for (Lotto ticket : generatedTickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
            assertThat(ticket.getNumbers()).isSorted();
            assertThat(ticket.getNumbers()).doesNotHaveDuplicates();
            assertThat(ticket.getNumbers())
                    .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
        }
    }

    @Test
    @DisplayName("올바른 상금 결과 도출 여부")
    void calculateResults_CorrectPrizeResults() {


        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        when(mockedLottos.get(0).countMatches(winningNumbers)).thenReturn(3); // Returns FIFTH prize
        when(mockedLottos.get(0).contains(bonusNumber)).thenReturn(false);
        when(mockedLottos.get(1).countMatches(winningNumbers)).thenReturn(5); // Returns THIRD prize
        when(mockedLottos.get(1).contains(bonusNumber)).thenReturn(false);


        Map<Prize, Integer> results = lottoService.calculateResults(winningNumbers, bonusNumber);


        assertThat(results.get(Prize.FIFTH)).isEqualTo(1);
        assertThat(results.get(Prize.THIRD)).isEqualTo(1);
        assertThat(results.get(Prize.NONE)).isEqualTo(0); // Assuming no other prizes were won
    }

    @Test
    @DisplayName("올바른 총 상금액 계산 여부")
    void calculateTotalEarnings_CorrectTotalEarnings() {

        Map<Prize, Integer> prizeResults = Map.of(
                Prize.FIFTH, 1, // 5등 1개 5,000원
                Prize.THIRD, 1  // 3등 1개 1,500,000 원
        );


        int totalEarnings = lottoService.calculateTotalEarnings(prizeResults);


        int expectedEarnings = Prize.FIFTH.getPrizeMoney() + Prize.THIRD.getPrizeMoney();
        assertThat(totalEarnings).isEqualTo(expectedEarnings);
    }

    @Test
    @DisplayName("올바른 수익률 계산 여부")
    void calculateYield_CorrectYield() {


        int purchaseAmount = 3000;
        int totalEarnings = 1505000;


        double yield = lottoService.calculateYield(purchaseAmount, totalEarnings);


        double expectedYield = (double) totalEarnings / purchaseAmount * 100;
        assertThat(yield).isEqualTo(expectedYield);
    }
}
