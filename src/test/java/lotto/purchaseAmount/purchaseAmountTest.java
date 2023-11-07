package lotto.purchaseAmount;

import lotto.model.LottoPurchaseAmount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class purchaseAmountTest {

    @Test
    void validate_양의_정수_1000의_배수면_참을_반환한다() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(9000);
        assertThat(lottoPurchaseAmount.getAmount()).isEqualTo(9000);
    }

    @Test
    void validate_음의_정수가_들어가면_거짓을_반환한다() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new LottoPurchaseAmount(-9000));
    }

    @Test
    void validate_1000의_배수가_아니면_거짓을_반환한다() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new LottoPurchaseAmount(9999));
    }
}
