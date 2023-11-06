package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.randomnumber.RandomNumberPicker;
import lotto.mock.FakeRandomNumberPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPublisherTest {

    @DisplayName("구입 금액 1000원 당 1개씩 로또를 발행할 수 있다.")
    @Test
    void publish2() {
        // given
        RandomNumberPicker randomNumberPicker = new FakeRandomNumberPicker(List.of(1, 2, 3, 4, 5, 6));
        LottoPublisher publisher = new LottoPublisher(randomNumberPicker);
        LottoPurchaseAmount purchaseAmount = new LottoPurchaseAmount(new BigDecimal(10000));

        // when
        LottoTickets result = publisher.publish(purchaseAmount);

        // then
        assertThat(result.getTickets()).hasSize(10);
    }

}
