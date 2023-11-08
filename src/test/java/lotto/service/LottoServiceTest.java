package lotto.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LottoServiceTest {

    @Mock
    private NumberGenerator numberGenerator;

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lottoService = new LottoService(numberGenerator);
    }

    @Test
    @DisplayName("주어진 금액으로 로또 티켓 생성 테스트")
    void createLottoTicketsTest() {
        when(numberGenerator.generateUniqueNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));

        int purchaseAmount = 3000;
        List<Lotto> lottos = lottoService.createLottoTickets(purchaseAmount);

        assertEquals(3, lottos.size());
        assertTrue(lottos.stream().allMatch(lotto -> lotto.getNumbers().equals(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    @DisplayName("구매 금액에 따른 로또 티켓 수 계산 테스트")
    void calculateNumberOfLottoTicketsTest() {
        int purchaseAmount = 3000;
        int expectedTicketCount = 3;

        int actualTicketCount = lottoService.calculateNumberOfLottoTickets(purchaseAmount);

        assertEquals(expectedTicketCount, actualTicketCount);
    }
}