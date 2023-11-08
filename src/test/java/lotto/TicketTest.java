package lotto;

import lotto.entity.Bonus;
import lotto.entity.Lotto;
import lotto.entity.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {
    @DisplayName("보너스 번호가 당첨 번호 중 하나라도 겹칠 경우 예외가 발생한다.")
    @Test
    void createTicketHavingBonusInLotto() {
        assertThatThrownBy(() ->
                new Ticket(new Lotto(List.of(1, 2, 3, 4, 9, 43)), new Bonus(43))
        )
                .isInstanceOf(IllegalArgumentException.class);
    }
}