package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerTest {
    private static final int LOTTO_PRICE = 1_000, VALID_MONEY_AMOUNT = 8_000, INVALID_MONEY_AMOUNT = 7_000;
    private Money money;
    private Lottos lottos;
    private Player player;

    @BeforeEach
    void setUp() {
        money = mock(Money.class);
        lottos = mock(Lottos.class);
    }

    @DisplayName("플레이어 생성")
    @Test
    void createPlayer_성공() {
        when(money.getAmount()).thenReturn(VALID_MONEY_AMOUNT);
        when(lottos.getSize()).thenReturn(VALID_MONEY_AMOUNT / LOTTO_PRICE);

        assertThatCode(() -> new Player(money, lottos)).doesNotThrowAnyException();

        verify(money, times(1)).getAmount();
        verify(lottos, times(1)).getSize();
    }

    @DisplayName("잘못된 구입 금액으로 인해 발행 로또의 수와 일치하지 않으면 예외 발생")
    @Test
    void createPlayer_Money가유효하지않은값일때() {
        when(money.getAmount()).thenReturn(INVALID_MONEY_AMOUNT);
        when(lottos.getSize()).thenReturn(VALID_MONEY_AMOUNT / LOTTO_PRICE);

        assertThatThrownBy(() -> new Player(money, lottos)).isInstanceOf(IllegalStateException.class);

        verify(money, times(1)).getAmount();
        verify(lottos, times(1)).getSize();
    }

    @DisplayName("잘못된 발행 로또로 인해 구입 금액과 일치하지 않으면 예외 발생")
    @Test
    void createPlayer_Lottos가유효하지않은값일때() {
        when(money.getAmount()).thenReturn(VALID_MONEY_AMOUNT);
        when(lottos.getSize()).thenReturn(INVALID_MONEY_AMOUNT / LOTTO_PRICE);

        assertThatThrownBy(() -> new Player(money, lottos)).isInstanceOf(IllegalStateException.class);

        verify(money, times(1)).getAmount();
        verify(lottos, times(1)).getSize();
    }

    @DisplayName("사용자의 구매 금액 객체 반환")
    @Test
    void getMoney() {
        player = new Player(money, lottos);

        assertThat(player.getMoney()).isEqualTo(money);
    }

    @DisplayName("사용자가 발행한 로또 리스트 객체 반환")
    @Test
    void getLottos() {
        player = new Player(money, lottos);

        assertThat(player.getLottos()).isEqualTo(lottos);
    }
}