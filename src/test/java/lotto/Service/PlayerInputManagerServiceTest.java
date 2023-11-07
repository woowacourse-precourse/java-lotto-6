package lotto.Service;

import lotto.Domain.PlayerPrice;
import lotto.Service.PlayerInputManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerInputManagerServiceTest {

    private PlayerInputManagerService playerInputManagerService;
    private PlayerPrice playerPrice;

    @BeforeEach
    public void setUp() {
        playerInputManagerService = new PlayerInputManagerService();
        playerPrice = new PlayerPrice(8000);
    }

    @DisplayName("구매 금액이 입력 정상 반환되는지 테스트한다.")
    @Test
    public void getBuyingPayTest() {
        int result = playerInputManagerService.getBuyingPay(playerPrice);

        assertThat(result).isEqualTo(8000);
    }

    @DisplayName("발행한 로또 수량이 구입금액과 맞는지 테스트한다.")
    @Test
    public void setPlayerLottoTicketsTest() {
        // When
        playerInputManagerService.setPlayerLottoTickets(playerPrice);

        // Then
        assertThat(playerPrice.getLottoTickets().size()).isEqualTo(8);
    }
}
