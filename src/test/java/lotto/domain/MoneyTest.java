package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {10001, 1100, -1})
    @DisplayName("올바르지 않은 금액이 들어오면 예외가 발생한다.")
    void failed(int inputValue) {
        assertThatThrownBy(() -> new Money(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또 티켓 장수가 맞지 않으면 예외가 발생한다.")
    void getTicketTest() {
        Money money = new Money(1000);
        assertThat(money.getTicket()).isEqualTo(1);
    }
}