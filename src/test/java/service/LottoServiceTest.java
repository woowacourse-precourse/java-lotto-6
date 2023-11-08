package service;

import lotto.model.Lotto;
import lotto.service.InputValidator;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoServiceTest {

    private LottoService lottoService;
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        inputValidator = new InputValidator();
    }

    @DisplayName("구입 금액에 따라 로또 티켓 수를 계산한다.")
    @Test
    void calculateNumberOfLottoTicketsToBuy() {
        int purchaseAmount = 8000;
        int expectedTicketCount = 8;
        int actualTicketCount = lottoService.calculateNumberOfLottoTicketsToBuy(purchaseAmount);
        assertEquals(expectedTicketCount, actualTicketCount);
    }

    @DisplayName("로또 티켓 개수에 따라 정확한 티켓 목록 생성한다.")
    @Test
    void generateLottoTickets() {
        int numberOfTickets = 3;
        List<Lotto> lottoTickets = lottoService.generateLottoTickets(numberOfTickets);
        assertEquals(numberOfTickets, lottoTickets.size());
    }

    @DisplayName("구입 금액에 따라 로또 티켓 목록 생성한다.")
    @Test
    void buyLottoTickets() {
        int purchaseAmount = 5000;
        int expectedTicketCount = 5;
        List<Lotto> lottoTickets = lottoService.buyLottoTickets(purchaseAmount);
        assertEquals(expectedTicketCount, lottoTickets.size());
    }

    @DisplayName("구입 금액이 1000원으로 나누어떨어지지 않는 경우 예외 처리한다.")
    @Test
    void purchaseAmountNotDivisibleBy1000Exception() {
        int purchaseAmount = 7777;
        assertThatThrownBy(() -> inputValidator.validateLottoPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
