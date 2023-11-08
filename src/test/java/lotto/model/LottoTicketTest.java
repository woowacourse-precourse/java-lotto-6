package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketTest {
    @DisplayName("로또 티켓 구입 금액이 1000원 미만이거나 1000원의 배수가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {800, 1200})
    void checkIfRangeOut(int inputBuyingCost) {
        assertThatThrownBy(() -> LottoTicket.isNotMultipleOfLottoPrice(inputBuyingCost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 로또 가격의 배수여야 합니다.");
    }
}
