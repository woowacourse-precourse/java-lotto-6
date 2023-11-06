package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {

    private static final int ONE_LOTTO_TICKET_PRICE = 1000;

    @Test
    @DisplayName("8000원을 입력하면, 로또 개수는 8개가 반환된다.")
    void 올바른_로또_갯수_반환() throws Exception{
        //given
        final int purchaseMoney = 8000;

        //when
        LottoCount lottoCount = new LottoCount(purchaseMoney);

        //then
        assertThat(lottoCount.getValue()).isEqualTo(purchaseMoney/ONE_LOTTO_TICKET_PRICE);
    }
}
