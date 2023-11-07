package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputPurchaseAmountTest {
    private static final int NEGATIVE_PURCHASE = -1000;
    private static final int NOT_DIVIDE_1000 = 100500;

    @DisplayName("입력 받은 로또 구입 가격이 int형 이지만 양수가 아니라면 예외가 발생한다.")
    @Test
    void createPurchaseByNegative() {
        assertThatThrownBy(() -> InputPurchaseAmount.inputPurchaseAmountPositive(NEGATIVE_PURCHASE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 로또 구입 가격이 1000 으로 나누어 떨어지지 않는다면 예외가 발생한다.")
    @Test
    void createPurchaseByNOTDivide1000() {
        assertThatThrownBy(() -> InputPurchaseAmount.inputPurchaseAmountDivisible1000(NOT_DIVIDE_1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
