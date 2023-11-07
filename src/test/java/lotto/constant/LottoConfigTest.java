package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoConfigTest {
    @DisplayName("PURCHASE_PRICE 값 테스트")
    @Test
    public void purchasePriceValue() {
        assertThat(LottoConfig.PURCHASE_PRICE.getValue()).isEqualTo(1000);
    }

    @DisplayName("MIN_LOTTO_NUMBER 값 테스트")
    @Test
    public void minLottoNumberValue() {
        assertThat(LottoConfig.MIN_LOTTO_NUMBER.getValue()).isEqualTo(1);
    }

    @DisplayName("MAX_LOTTO_NUMBER 값 테스트")
    @Test
    public void maxLottoNumberValue() {
        assertThat(LottoConfig.MAX_LOTTO_NUMBER.getValue()).isEqualTo(45);
    }

    @DisplayName("TOTAL_CHOICE_NUMBER 값 테스트")
    @Test
    public void totalChoiceNumberValue() {
        assertThat(LottoConfig.TOTAL_CHOICE_NUMBER.getValue()).isEqualTo(6);
    }
}