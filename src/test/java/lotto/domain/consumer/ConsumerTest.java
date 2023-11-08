package lotto.domain.consumer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsumerTest {

    private static final Integer PRICE_1000 = 1000;
    private static final Integer COUNT_FROM_PRICE_1000 = PRICE_1000 / 1000;

    private static final Integer PRICE_2000 = 2000;
    private static final Integer COUNT_FROM_PRICE_2000 = PRICE_2000 / 1000;

    private static final Integer PRICE_3000 = 3000;
    private static final Integer COUNT_FROM_PRICE_3000 = PRICE_3000 / 1000;

    @DisplayName("소비자가 로또를 1000 원 구매했다면 1개를 가지고 있어야 함.")
    @Test
    void testConsumerPaying1000() {
        Consumer consumerPaying1000 = new Consumer(new Price(PRICE_1000));
        Count count = consumerPaying1000.count();

        Assertions.assertThat(count.value()).isEqualTo(COUNT_FROM_PRICE_1000);
    }

    @DisplayName("소비자가 로또를 2000 원 구매했다면 2개를 가지고 있어야 함.")
    @Test
    void testConsumerPaying2000() {
        Consumer consumerPaying2000 = new Consumer(new Price(PRICE_2000));
        Count count = consumerPaying2000.count();

        Assertions.assertThat(count.value()).isEqualTo(COUNT_FROM_PRICE_2000);

    }

    @DisplayName("소비자가 로또를 3000원어치 구매했다면 3개를 가지고 있어야 함")
    @Test
    void testConsumerPaying3000() {
        Consumer consumerPaying3000 = new Consumer(new Price(PRICE_3000));
        Count count = consumerPaying3000.count();

        Assertions.assertThat(count.value()).isEqualTo(COUNT_FROM_PRICE_3000);
    }
}
