package lotto.model;

import static lotto.common.ExceptionMessage.ERROR_INPUT_NOT_MULTIPLE_OF_THOUSAND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {
    @DisplayName("유효한 금액 입력 값으로 PurchaseAmount를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 15000})
    void createPurchaseAmountByValidInput(int validAmount) {
        PurchaseAmount purchaseAmount = PurchaseAmount.from(validAmount);

        assertThat(purchaseAmount).isNotNull();
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(validAmount);
        assertThat(purchaseAmount.calculateLottoCount()).isEqualTo(validAmount / 1000);
    }

    @DisplayName("1000의 배수가 아닌 금액으로 PurchaseAmount를 생성하면 예외를 발생 시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 200, 1999})
    void throwExceptionWhenAmountIsNotMultipleOfThousand(int invalidAmount) {
        assertThatThrownBy(() -> PurchaseAmount.from(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_INPUT_NOT_MULTIPLE_OF_THOUSAND);
    }
}
