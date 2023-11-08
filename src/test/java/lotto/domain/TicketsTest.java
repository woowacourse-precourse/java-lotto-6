package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketsTest {
    @DisplayName("Lotto형 List에 대한 getter는 불변 리스트를 반환한다. 이를 수정할 경우 오류가 발생한다.")
    @Test
    void provideUnmodifiableListByGetter() {
        Tickets tickets = createMockTickets();
        List<Lotto> unmodifiableTickets = tickets.getTickets();
        Lotto mockTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> unmodifiableTickets.add(mockTicket)).isInstanceOf(
                UnsupportedOperationException.class);
    }

    @DisplayName("메서드를 통해 발행된 로또 티켓의 총 개수를 얻을 수 있다.")
    @Test
    void getTicketAmountFromMethod() {
        Tickets tickets = createMockTickets();
        assertThat(tickets.getTicketAmount()).isEqualTo(10);
    }

    @DisplayName("정답 객체를 매개변수로 받아 List 내부의 Lotto 객체와 비교를 진행한 뒤 최종 결과를 반환한다.")
    @Test
    void compareTicketsToAnswerAndReturnTotalResult() {
        Tickets tickets = createMockTickets();
        Lotto mockHitNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Answer answer = new Answer(mockHitNumbers, 7);
        assertThat(tickets.compareTicketsToAnswer(answer)).isInstanceOf(TotalResult.class);
    }

    private Tickets createMockTickets() {
        LottoMachine machine = new LottoMachine();
        return machine.generateTickets(10000);
    }
}
