package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("입력받은 금액에 맞는 갯수의 lotto 티켓을 발행한다.")
    void issueLottoTicket() {
        // given
        Integer amount = 14000;
        Money money = new Money(amount);

        // when
        Integer issuedLottoTicket = money.issueLottoTicket();

        // then
        Integer expectTicketCount = 14;
        assertThat(issuedLottoTicket).isEqualTo(expectTicketCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 999, -123, })
    @DisplayName("입력받은 금액이 1000원 미만인 경우, 예외를 발생시킨다.")
    void validate_lessThanThousand(Integer amount) {
        // then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 이상만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1111, 1234, 10005})
    @DisplayName("입력받은 금액이 1000원 단위가 아닌 경우, 예외를 발생시킨다.")
    void validate_nonThousandUnit(Integer amount) {
        // then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 단위로만 입력 가능합니다.");
    }


}