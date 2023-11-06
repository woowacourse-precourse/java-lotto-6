package lotto.service;

import static lotto.globar.GlobalConstants.SINGLE_LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.globar.GlobalConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    @DisplayName("로또구매금액을 통해 로또를 구매했을 때, 원하는 만큼 로또의 개수가 나온다. ")
    @DisplayName("When purchasing lotto tickets with a specific price")
    void testIssueLottoTickets() {
        // given
        int purchasePrice = 4000;
        int purchaseLottoSize = purchasePrice / SINGLE_LOTTO_PRICE;

        // when
        List<Lotto> lottos = LottoService.issueLottoTickets(purchasePrice);

        // then
        Assertions.assertEquals(purchaseLottoSize, lottos.size());
    }
}