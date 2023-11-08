package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMoneyTest {

    @Test
    void getLottoAmountTest() {
        //given
        LottoMoney money = new LottoMoney(5000);

        //when
        int amount = money.getLottoAmount();

        //then
        Assertions.assertThat(amount).isEqualTo(5);
    }
}
