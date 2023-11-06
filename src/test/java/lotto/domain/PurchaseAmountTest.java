package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {
    @DisplayName("구입 금액이 1원 미만이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -23})
    void purchaseAmountBelowOne(int money) {
        assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1원 이상이어야 합니다.");
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 999, 1, 42342})
    void purchaseAmountIsNotMultipleOfThousand(int money) {
        assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액이 1000원 단위이어야 합니다.");
    }

    @DisplayName("구입 금액이 1원 이상이고 1000원 단위일 경우 정상 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 35000, 14000})
    void purchaseAmountCreateSuccessfully(int money) {
        assertThatNoException()
                .isThrownBy(() -> new PurchaseAmount(money));
    }
}