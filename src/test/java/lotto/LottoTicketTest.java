package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    @DisplayName("구입 금액이 로또 티켓의 가격에 알맞지 않은 경우 예외를 던진다.")
    void createUserByInvalidBudget() {

        //given
        int invalidBudget = LottoTicket.PRICE_OF_LOTTO_TICKET + 1;

        //when & then
        assertThatThrownBy(() -> LottoTicket.validateAffordability(invalidBudget))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
