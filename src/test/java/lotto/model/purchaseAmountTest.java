package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("PurchaseAmount 모델 검증 테스트")
public class purchaseAmountTest {

    @Test
    @DisplayName("양의 정수, 1000의 배수면 성공한다.")
    void success() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(9000);
        assertThat(lottoPurchaseAmount.amount()).isEqualTo(9000);
    }

    @Test
    @DisplayName("음의 정수면 예외가 발생한다.")
    void fail1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseAmount(-9000));
    }

    @Test
    @DisplayName("1000의 배수가 아니면 예외가 발생한다.")
    void fail2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseAmount(9999));
    }
}
