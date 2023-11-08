package lotto.domain.seller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.fake.FakeRandomNumber;
import lotto.domain.generator.AutoTicketGenerator;
import lotto.domain.generator.TicketGenerator;
import lotto.domain.money.Money;
import lotto.domain.ticket.Ticket;
import lotto.util.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketSellerTest {
        @DisplayName("성공: 주어진 금액으로 최대로 구매 가능한 티켓을 판매할 수 있다.")
        @Test
        void call_sellTo_will_return_Ticket() {
                //given
                List<Integer> lottoBalls = List.of(1, 2, 3, 4, 5, 6);
                RandomNumbers randomNumber = new FakeRandomNumber(lottoBalls);
                TicketGenerator generator = new AutoTicketGenerator(randomNumber);
                Seller seller = new TicketSeller(generator);
                Money payment = new Money(BigDecimal.valueOf(6000));

                //when
                Ticket ticket = seller.sellTo(payment);

                //then
                assertThat(ticket).isNotNull();
                assertThat(ticket.getNumOfLottoEntry()).isEqualTo(6);
        }
}
