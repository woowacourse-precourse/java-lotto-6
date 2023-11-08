package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoCountTest {
    @DisplayName("구매 금액은 0보다 큰 값이고 로또 가격 단위로 나누어 떨어져야 한다.")
    @ParameterizedTest
    @CsvSource({"0", "-8000","500"})
    void lottoCountValidateTest(int customerPrice) {
        assertThatThrownBy(() -> NumberValidator.validateLottoCount(customerPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
