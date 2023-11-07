package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAmountTest {
    @DisplayName("금액이 0보다 작거나 같은 경우")
    @Test
    void validateAmount(){
        LottoAmount lottoAmount = new LottoAmount();

        assertThatThrownBy(() -> lottoAmount.initLottoAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}