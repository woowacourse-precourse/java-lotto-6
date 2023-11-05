package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.randomnumber.RandomNumberPicker;
import lotto.mock.FakeRandomNumberPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPublisherTest {

    @DisplayName("정해진 수량 만큼 로또를 발행할 수 있다.")
    @Test
    void publish() {
        // given
        RandomNumberPicker randomNumberPicker = new FakeRandomNumberPicker(List.of(1, 2, 3, 4, 5, 6));
        LottoPublisher publisher = new LottoPublisher(randomNumberPicker);
        int quantity = 6;

        // when
        LottoTickets tickets = publisher.publish(quantity);

        // then
        assertThat(tickets.getTickets()).hasSize(quantity);
    }

}
