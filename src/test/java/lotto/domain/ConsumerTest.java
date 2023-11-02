package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsumerTest {

    private final int LESS_AMOUNT = 900;
    private final int GREATER_AMOUNT = 101000;
    private final int DIVIDE_AMOUNT = 1250;
    private final int AMOUNT = 2000;

    @Test
    @DisplayName("구매자의 구매 금액이 1,000원 이하인 경우 예외가 발생한다.")
    void buyAmountLessThan1000() {
        assertThatThrownBy(() -> new Consumer(LESS_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매자의 구매 금액이 100,000원 이상인 경우 예외가 발생한다.")
    void buyAmountGreaterThan100000() {
        assertThatThrownBy(() -> new Consumer(GREATER_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매자의 구매 금액이 1,000원 으로 떨어 지지 않는 경우 예외가 발생한다.")
    void divideByBuyAmount1000() {
        assertThatThrownBy(() -> new Consumer(DIVIDE_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매자의 구매 금액이 정상적으로 입력된 경우 저장")
    void buyAmountSave() {
        Consumer consumer = new Consumer(AMOUNT);

        assertThat(consumer.getBuyAmount()).isEqualTo(AMOUNT);
    }

}