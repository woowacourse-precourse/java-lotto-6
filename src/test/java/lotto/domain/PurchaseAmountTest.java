package lotto.domain;

import static lotto.settings.ErrorMessage.INVALID_UNIT_FORMAT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("구입 금액은 1000원 단위여야 정상적으로 저장된다.")
    @Test
    void createCorrect() {
        PurchaseAmount purchaseAmount = PurchaseAmount.from(3000);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {20123,1002,100,20,1})
    void validateUnits(int purchaseAmount) {
        assertThatThrownBy(()->PurchaseAmount.from(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIT_FORMAT.getMessage());

        assertThatIllegalArgumentException()
                .isThrownBy(()->PurchaseAmount.from(purchaseAmount))
                .withMessage(INVALID_UNIT_FORMAT.getMessage());
    }

    @DisplayName("구입 금액으로 몇개의 복권을 살수있는지 계산해준다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1","5000,5","14000,14"})
    void calculateCount(int money, int purchaseCount) {
        // when
        PurchaseAmount purchaseAmount = PurchaseAmount.from(money);
        // then
        Assertions.assertThat(purchaseAmount.calculateCount()).isEqualTo(purchaseCount);
    }
}