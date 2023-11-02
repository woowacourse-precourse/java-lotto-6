package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsumerTest {

    @Test
    @DisplayName("구매자의 구매 금액이 1,000원 이하인 경우 예외가 발생한다.")
    void buyAmountLessThan1000() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Consumer(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매자의 구매 금액이 100,000원 이상인 경우 예외가 발생한다.")
    void buyAmountGreaterThan100000() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Consumer(101000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매자의 구매 금액이 1,000원 으로 떨어 지지 않는 경우 예외가 발생한다.")
    void divideByBuyAmount1000() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Consumer(1250))
                .isInstanceOf(IllegalArgumentException.class);
    }

}