package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.fake.FakeRandomNumber;
import lotto.domain.ticket.Ticket;
import lotto.util.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutoTicketGeneratorTest {

        @DisplayName("성공: 주어진 로또 수를 포함한 티켓을 생성할 수 있다.")
        @Test
        void call_generateTicket_will_return_Ticket() {
                //given
                long quantity = 3;
                List<Integer> lottoBalls = List.of(1, 2, 3, 4, 5, 6);
                RandomNumbers randomNumber = new FakeRandomNumber(lottoBalls);
                TicketGenerator generator = new AutoTicketGenerator(randomNumber);

                //when
                Ticket ticket = generator.generateTicket(quantity);

                //then
                assertThat(ticket).isNotNull();
                assertThat(ticket.getNumOfLottoEntry()).isEqualTo(3);
        }

}
