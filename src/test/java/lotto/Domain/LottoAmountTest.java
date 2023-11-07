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

    @DisplayName("금액이 1000의 배수가 아닌 경우")
    @Test
    void validateAmount2(){
        LottoAmount lottoAmount = new LottoAmount();

        assertThatThrownBy(() -> lottoAmount.initLottoAmount(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

}