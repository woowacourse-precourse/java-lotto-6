package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {

    @DisplayName("로또 구입 금액이 천원단위가 아니면 예외가 발생한다.")
    @Test
    void validateLottoPurchaseAmount() {

        LottoManager lottoManager = new LottoManager();

        int validPurchaseAmount = 10000;
        lottoManager.isValidPurchaseAmount(validPurchaseAmount);

        int invalidPurchaseAmount = 10500;
        assertThatThrownBy(() -> lottoManager.isValidPurchaseAmount(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
