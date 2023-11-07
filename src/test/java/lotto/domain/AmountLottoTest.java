package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AmountLottoTest {

    @Test
    void 구입금액_로또_갯수_반환_테스트() {
        AmountLotto amountLotto = new AmountLotto("5000");
        assertThat(amountLotto.calculateAmountLotto()).isEqualTo(5);
    }

}