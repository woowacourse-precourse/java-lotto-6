package lotto.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("로또 구입 금액으로 Player 를 생성하고, 금액을 전부 사용해 티켓을 발급받는다.")
    @Test
    void playerTest() {
        // Given
        Player player = new Player(10000);
        // When
        player.consumeAllMoneyToLottoTicket();
        // Then
        assertThat(player.getTicketNumber()).isEqualTo(10);
    }

}
