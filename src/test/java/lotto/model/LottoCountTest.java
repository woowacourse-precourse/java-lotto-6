package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

    @DisplayName("구매 금액에 맞는 로또 수량을 발행하는지 테스트")
    @Test
    void createLottoCount() {
        int amount = 10000;
        LottoCount lottoCount = LottoCount.createLottoCount(amount);
        assertThat(lottoCount.getLottoCount()).isEqualTo(10);
    }


}