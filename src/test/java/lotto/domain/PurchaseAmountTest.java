package lotto.domain;

import static lotto.constants.ErrorMessage.AMOUNT_UNDER_THOUSAND_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.NON_THOUSAND_MULTIPLE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {
    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -2300, 999})
    void purchaseAmountBelowOne(int money) {
        assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_UNDER_THOUSAND_ERROR_MESSAGE);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 42342})
    void purchaseAmountIsNotMultipleOfThousand(int money) {
        assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_THOUSAND_MULTIPLE_ERROR_MESSAGE);
    }

    @DisplayName("구입 금액이 1원 이상이고 1000원 단위일 경우 정상 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 35000, 14000})
    void purchaseAmountCreateSuccessfully(int money) {
        assertThatNoException()
                .isThrownBy(() -> new PurchaseAmount(money));
    }
}