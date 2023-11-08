package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.util.Constants;
import lotto.util.RandomLottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    void init() {
        lottoStore = new LottoStore(Constants.LOTTO_PRICE, new RandomLottoGenerator());
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {0, -1000, 1234})
    void 유효하지_않은_구매금액일_경우_예외_발생(int purchaseAmount) {
        //when & then
        assertThrows(IllegalArgumentException.class, () ->
                lottoStore.purchaseRandomLottoTickets(purchaseAmount));
    }

    @Test
    void 구입금액만큼_로또_발행() {
        //then
        int expected = 8;
        int purchaseAmount = expected * Constants.LOTTO_PRICE;

        //when
        LottoTickets lottoTickets = lottoStore.purchaseRandomLottoTickets(purchaseAmount);

        //then
        assertEquals(expected, lottoTickets.getSize());
    }

}
