package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.core.LottoGameController;
import lotto.preprocessor.PurchasePreprocessor;
import lotto.preprocessor.WinningNumsPreprocessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameControllerTest {

    PurchasePreprocessor purchasePreprocessor = new PurchasePreprocessor();
    WinningNumsPreprocessor winningNumsPreprocessor = new WinningNumsPreprocessor();

    @DisplayName("로또 구매 금액이 조건에 맞지 않으면 true를 반환한다.")
    @Test
    void isInvalidPurchaseTest() {
        assertThat(purchasePreprocessor.isInvalid("1234")).isTrue();
        assertThat(purchasePreprocessor.isInvalid("-1234")).isTrue();
        assertThat(purchasePreprocessor.isInvalid("0")).isTrue();
        assertThat(purchasePreprocessor.isInvalid("1000")).isFalse();
    }



}