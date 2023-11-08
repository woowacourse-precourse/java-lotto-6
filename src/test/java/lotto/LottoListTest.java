package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoListTest {

    @DisplayName("로또 개수가 정상적으로 발행되는지 확인한다.")
    @Test
    void 구입금액에_따른_로또_개수_확인() {
        // given
        int amount = 10000;
        LottoList lottoList = new LottoList(amount);

        // when
        lottoList.createLottoList();

        // then
        assertEquals(10, lottoList.getNumber_of_lotto());
        assertEquals(10, lottoList.getLottoList().size());
    }
}