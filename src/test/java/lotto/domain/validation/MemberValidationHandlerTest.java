package lotto.domain.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

class MemberValidationHandlerTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000, 100000})
    @DisplayName("1,000원 단위의 금액은 예외가 발생하지 않는다.")
    void validationLottoPurchaseAmountUnit(int amount) {
        // given // when // then
        MemberValidationHandler.validationLottoPurchaseAmountUnit(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 100, 1001, 1010, 1100, 1101, 1110, 1111, 12345})
    @DisplayName("1,000원 단위의 금액이 아니면 예외가 발생한다.")
    void validationLottoPurchaseAmountUnitException(int amount) {
        // given // when // then
        assertThatThrownBy(() -> MemberValidationHandler.validationLottoPurchaseAmountUnit(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MemberValidationHandler.INVALID_LOTTO_PURCHASE_UNIT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000, 100000})
    @DisplayName("로또가 100개 이하이면 예외가 발생하지 않는다.")
    void validationMaxLottoCount(int amount) {
        // given // when // then
        MemberValidationHandler.validationRangeLottoCount(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 101000})
    @DisplayName("로또가 0개 이거나 100개 이상이면 예외가 발생한다.")
    void validationMaxLottoCountException(int amount) {
        // given // when // then
        assertThatThrownBy(() -> MemberValidationHandler.validationRangeLottoCount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MemberValidationHandler.INVALID_RANGE_LOTTO_PURCHASE_COUNT_MESSAGE);

    }
}