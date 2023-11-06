package lotto.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemoryTicketRepositoryTest {

    private MemoryTicketRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MemoryTicketRepository();
    }

    @DisplayName("티켓을 구매하면 메모리에 저장한다.")
    @Test
    void purchaseMethodTest() {
        //given
        Ticket ticket = new Ticket();

        //when
        repository.purchase(ticket);

        //then
        assertTrue(repository.findAll().contains(ticket));
    }

}