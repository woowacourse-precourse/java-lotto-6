package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import lotto.dto.response.LottosInfoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @DisplayName("Player가 로또 티켓을 구매하고 저장하는지 테스트")
    @Test
    public void testBuyLottos() {
        // Given
        String input = "14000";
        Player player = new Player(input);
        int ticketCount = 14;
        LottosInfoDto lottosInfoDto = new LottosInfoDto(ticketCount, null); //numbers에 null을 넣어서 NotEqual 유됴
        // When
        LottoShop lottoShop = mock(LottoShop.class);
        when(lottoShop.sellLottos(player.getMoney())).thenReturn(lottosInfoDto);
        LottosInfoDto result = player.buyLottos();
        // Then
        assertNotEquals(lottosInfoDto, result);
        Lottos playerLottos = player.getLottos();
        assertEquals(ticketCount, playerLottos.getLottos().size());
    }
}