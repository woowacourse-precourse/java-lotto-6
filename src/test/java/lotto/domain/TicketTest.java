package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_UNIT;
import static lotto.exception.ErrorMessage.NOT_ENOUGH_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TicketTest {

    @DisplayName("투입한 금액이 1000원 단위면 티켓이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 1000000})
    void of(int input) {
        // given // when
        Ticket ticket = Ticket.from(input);

        // then
        assertThat(ticket)
                .extracting("count")
                .isEqualTo(input / 1000);
    }

    @DisplayName("투입한 금액이 1000원 이상이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 300, 500, 999})
    void ofNotEnoughMoney(int input) {
        assertThatThrownBy(() -> Ticket.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ENOUGH_MONEY.getMessage());
    }

    @DisplayName("투입한 금액이 1000원 단위이어야 한다.")
    @Test
    void ofByNotUnit() {
        // given
        int money = 5100;

        // when then
        assertThatThrownBy(() -> Ticket.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIT.getMessage());
    }

    @DisplayName("티켓 수량만큼 로또를 살 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 1000000})
    void buyLottos(int input) {
        // given
        Ticket ticket = Ticket.from(input);

        // when
        Lottos lottos = ticket.buyLottos(() -> List.of(1,2,3,4,5,6));

        // then
        assertThat(lottos.getLottoNumbers())
                .hasSize(input / 1000)
                .contains("[1, 2, 3, 4, 5, 6]");
    }
}