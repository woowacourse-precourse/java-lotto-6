package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.dto.response.LottosInfoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    @DisplayName("Ticket이 돈에 맞게 생성 되는지 테스트")
    @Test
    public void testSellLottos() {
        // Given
        LottoShop lottoShop = new LottoShop();
        int money = 14000;
        // When
        LottosInfoDto lottosInfoDto = lottoShop.sellLottos(money);
        int expectedTicketCount = money / ConstantValue.THOUSAND;
        // Then
        assertEquals(expectedTicketCount, lottosInfoDto.ticket());
    }

}