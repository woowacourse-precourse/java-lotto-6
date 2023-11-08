package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PlayerTest {
    private Money money;
    private Lottos lottos;
    private Player player;

    @BeforeEach
    void setUp() {
        money = mock(Money.class);
        lottos = mock(Lottos.class);
        player = new Player(money, lottos);
    }

    @DisplayName("사용자의 구매 금액 객체 반환")
    @Test
    void getMoney() {
        assertThat(player.getMoney()).isEqualTo(money);
    }

    @DisplayName("사용자가 발행한 로또 리스트 객체 반환")
    @Test
    void getLottos() {
        assertThat(player.getLottos()).isEqualTo(lottos);
    }
}