package lotto.service;

import static lotto.util.rule.GameRule.TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;
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
        String input = "8000";
        Integer money = Integer.parseInt(input);
        int expectedTicketCount = money / TICKET_PRICE.getValue();

        //when
        int ticketCount = ticketService.purchaseAmount(input);

        //wthen
        assertEquals(expectedTicketCount, ticketCount);
    }

    @DisplayName("구매비용이 1,000원 단위가 아니라면 에러가 발생한다.")
    @Test
    void purchaseAmountMethodUnitExceptionTest() {
        String input = "8500"; // 유효하지 않은 금액
        assertThrows(IllegalArgumentException.class, () -> ticketService.purchaseAmount(input));
    }

    @DisplayName("자동 구매한 번호를 저장한다.")
    @Test
    void automaticPurchaseMethodTest() {
        Ticket ticket = ticketService.automaticPurchase();
        List<Ticket> storedTickets = memoryTicketRepository.findAll();
        assertTrue(storedTickets.contains(ticket));
    }

    @DisplayName("당첨 번호 입력이 유효하면 WinningTicket 객체를 생성한다.")
    @Test
    void announcementNumberInputTest() {
        String validInput = "1,2,3,4,5,6";
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningTicket winningTicket = ticketService.announcementNumber(validInput);
        assertEquals(validNumbers.toString(), winningTicket.getLotto().toString());
    }

    @DisplayName("당첨 번호 입력이 유효하지 않으면 예외가 발생한다.")
    @Test
    void announcementNumberValidInputTest() {
        String invalidRange = "1,2,3,4,5,46"; // 범위 초과
        String invalidSize = "1,2,3,4,5"; // 개수 부족
        String invalidUnique = "1,2,3,4,5,5"; // 중복

        assertThrows(IllegalArgumentException.class,
                () -> ticketService.announcementNumber(invalidRange));
        assertThrows(IllegalArgumentException.class,
                () -> ticketService.announcementNumber(invalidSize));
        assertThrows(IllegalArgumentException.class,
                () -> ticketService.announcementNumber(invalidUnique));
    }

}