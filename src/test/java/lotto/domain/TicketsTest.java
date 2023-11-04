package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketsTest {
    @DisplayName("Lotto를 입력하면 자신의 리스트에 입력한 Lotto를 추가한다.")
    @Test
    void generateTicketsTest() {
        // 초기 티켓 갯수 확인
        Tickets tickets = new Tickets();
        int initialCount = tickets.getTicketsCount();

        // 새로운 티켓 2장 추가
        tickets.generateTickets(2);

        // 추가한 후 갯수 확인
        int addedCount = tickets.getTicketsCount();

        // 티켓이 올바르게 추가되었는지 확인
        assertTrue(addedCount - initialCount == 2);
    }

}
