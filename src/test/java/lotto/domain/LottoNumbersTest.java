package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.SystemNumbers.TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {

    @DisplayName("로또를 구입한 개수만큼 로또를 추첨한다.")
    @Test
    void createLottoByPurchasedAmount() {
        // given
        int amount = 8000;
        LottoNumbers lottoNumbers = LottoNumbers.validate(amount);

        // when
        lottoNumbers.drawnLottoNumbers();
        List<Lotto> drawnLottos = lottoNumbers.getDrawnLottoNumbers();

        // then
        assertEquals(amount/TICKET_PRICE.getNumber(), drawnLottos.size());
    }
}
