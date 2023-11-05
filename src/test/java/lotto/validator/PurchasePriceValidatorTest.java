package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchasePriceValidatorTest {
    private final PurchasePriceValidator purchasePriceValidator = new PurchasePriceValidator();

    @DisplayName("구입 금액이 1000원 단위로 나눠지지 않는 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1014, 20001, 10001})
    void checkRemainderNotZero(int price) {
        assertThatThrownBy(() -> purchasePriceValidator.checkRemainderZero(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 1000으로 나눠지지 않습니다. 1000원 단위로 입력해주세요.");
    }

    @DisplayName("구입 금액이 1000원 단위로 나눠지는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 20000})
    void checkRemainderZero(int price) {
        assertThatCode(() -> purchasePriceValidator.checkRemainderZero(price))
                .doesNotThrowAnyException();
    }
}
