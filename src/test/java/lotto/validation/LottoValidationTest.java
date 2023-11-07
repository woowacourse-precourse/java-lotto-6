package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidationTest {

    LottoValidation lottoValidation = new LottoValidation();

    @Test
    @DisplayName("구매 금액은 1,000원 단위로 숫자만 입력해야 한다.")
    void validatePurchasePrice() {
        // given
        String notDigitValue = "1000j";
        String notDivisibleValue = "10001";
        String divisibleValue = "1000";

        // then
        assertThatThrownBy(() -> lottoValidation.validatePurchasePrice(notDigitValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoValidation.validatePurchasePrice(notDivisibleValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatNoException().isThrownBy(() -> lottoValidation.validatePurchasePrice(divisibleValue));
    }

}