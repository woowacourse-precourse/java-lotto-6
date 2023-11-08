package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketTest {
    @DisplayName("로또 티켓 구입 금액이 1000원 미만 또는 1000의 배수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {800, 1200, 1300})
    void checkIfInvalidBuyingCost(int inputBuyingCost) {
        assertThatThrownBy(() -> LottoTicket.isNotMultipleOfLottoPrice(inputBuyingCost))
                .isInstanceOf(IllegalArgumentException.class);
    }
}