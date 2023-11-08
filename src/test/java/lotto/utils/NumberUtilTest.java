package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberUtilTest {

    @Test
    void 구매금액에서_로또_개수_알기() {
        //given
        int lottoPrice = 1000;
        int purchaseAmount = 2000;

        //when
        int lottoCount = NumberUtil.toLottoCount(purchaseAmount, lottoPrice);
        
        //then
        Assertions.assertThat(2).isEqualTo(lottoCount);
    }

}
