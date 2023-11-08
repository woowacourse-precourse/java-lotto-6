package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @DisplayName("무작위 숫자 생성 테스트")
    @Test
    public void testCreateNumbers() {
        // Given
        LottoShop lottoShop = new LottoShop();
        int ticketCount = 5;
        // When
        List<List<Integer>> numbers = lottoShop.createNumbers(ticketCount);
        // Then
        assertEquals(ticketCount, numbers.size());
        for (List<Integer> numberList : numbers) {
            assertEquals(6, numberList.size());
            for (int number : numberList) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }
}