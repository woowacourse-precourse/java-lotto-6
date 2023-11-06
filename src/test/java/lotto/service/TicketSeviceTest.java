package lotto.service;

import static lotto.util.constant.GameRule.TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Ticket;
import lotto.repository.MemoryTicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketSeviceTest {

    private TicketService ticketService;
    private MemoryTicketRepository memoryTicketRepository;

    @BeforeEach
    void setUp() {
        memoryTicketRepository = new MemoryTicketRepository();
        ticketService = new TicketService(memoryTicketRepository);
    }

    @DisplayName("구매비용이 1,000원 단위라면 정상적으로 티켓을 구매한다.")
    @Test
    void purchaseAmountMethodTest() {
        //given
        int money = 8000;
        int expectedTicketCount = money / TICKET_PRICE.getValue();

        //when
        int ticketCount = ticketService.purchaseAmount(money);

        //wthen
        assertEquals(expectedTicketCount, ticketCount);
    }

    @DisplayName("구매비용이 1,000원 단위가 아니라면 에러가 발생한다.")
    @Test
    void purchaseAmountMethodUnitExceptionTest() {
        int money = 8500; // 유효하지 않은 금액
        assertThrows(IllegalArgumentException.class, () -> ticketService.purchaseAmount(money));
    }

    @DisplayName("자동 구매한 번호를 저장한다.")
    @Test
    void automaticPurchaseMethodTest() {
        Ticket ticket = ticketService.automaticPurchase();
        List<Ticket> storedTickets = memoryTicketRepository.findAll();
        assertTrue(storedTickets.contains(ticket));
    }

}