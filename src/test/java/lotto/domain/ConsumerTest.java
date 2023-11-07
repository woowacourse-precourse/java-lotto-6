package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsumerTest {

    @DisplayName("구매 금액을 저장한다.")
    @Test
    void savePurchaseAmount() {
        //Given
        Consumer consumer = new Consumer();
        //When
        consumer.setPurchaseAmount(5000);
        //Then
        assertThat(consumer.getPurchaseAmount()).isEqualTo(5000);
    }

    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않는다면 예외가 발생한다.")
    @Test
    void savePurchaseAmountByNotDivided() {
        Consumer consumer = new Consumer();
        assertThatThrownBy(() -> consumer.setPurchaseAmount(5001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
    }
}
