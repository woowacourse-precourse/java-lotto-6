package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsumerTest {

    @DisplayName("구매금액을 저장한다.")
    @Test
    void savePurchaseAmount() {
        //Given
        Consumer consumer = new Consumer();
        //When
        consumer.setPurchaseAmount(5000);
        //Then
        assertThat(consumer.getPurchaseAmount()).isEqualTo(5000);
    }
}
