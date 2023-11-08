package lotto;

import lotto.Service.LottoService;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    void getTicketCountWithInvalidMoneyTest() {
        LottoService lottoService = new LottoService();

        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.getTicketCount(500);
        });
    }
    @Test
    void compareNumbersTest() {
        LottoService lottoService = new LottoService();
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 13, 14, 15);

        List<Integer> matchedNumbers = lottoService.CompareNumbers(purchasedLottos, winningNumbers);
        assertEquals(List.of(3, 0), matchedNumbers);
    }
    @Test
    void compareBonusNumbersTest() {
        LottoService lottoService = new LottoService();
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        int bonusBall = 7;

        boolean isBonusBall = lottoService.CompareBonusNumbers(purchasedLottos, bonusBall);
        assertTrue(isBonusBall);
    }
}
