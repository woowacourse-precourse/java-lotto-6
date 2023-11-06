package lotto.model.validator;

import static lotto.model.util.ExceptionMessage.BIGGER_THAN_MAX;
import static lotto.model.util.ExceptionMessage.INVALID_INPUT_TYPE;
import static lotto.model.util.ExceptionMessage.NOT_DIVIDE_BY_LOTTO_PRICE;
import static lotto.model.util.ExceptionMessage.NOT_POSITIVE_INPUT;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountOfLottoValidatorTest {
    private AmountOfLottoValidatorImpl amountOfLottoValidator;

    @BeforeEach
    void beforeEach() {
        amountOfLottoValidator = new AmountOfLottoValidatorImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5000"})
    @DisplayName("올바른 Integer입력 시 어떠한 에러도 반환되지 않는다.")
    void typeSuccessTest(String amountOfLotto) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> amountOfLottoValidator.checkType(amountOfLotto));
    }

    @ParameterizedTest
    @ValueSource(strings = {"wrong"})
    @DisplayName("숫자를 입력하지 않을 시 IllegalArgumentException이 반환된다.")
    void notNumberFailTest(String amountOfLotto) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> amountOfLottoValidator.checkType(amountOfLotto))
                .withMessage(INVALID_INPUT_TYPE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(longs = {2147483648L})
    @DisplayName("Integer 자료형이 아닐 경우 IllegalArgumentException이 반환된다.")
    void biggerThanIntegerMaxFailTest(Long amountOfLotto) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> amountOfLottoValidator.checkAmountWithinLottoPriceRange(amountOfLotto))
                .withMessage(BIGGER_THAN_MAX.getMessage());
    }

    @ParameterizedTest
    @ValueSource(longs = {1000})
    @DisplayName("양수 입력 시 어떠한 에러도 반환되지 않는다.")
    void integerSuccessTest(Long amountOfLotto) {
        // given
        // when & then
        assertThatNoException().isThrownBy(
                () -> amountOfLottoValidator.checkAmountWithinLottoPriceRange(amountOfLotto));
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1, -2, -3})
    @DisplayName("양수가 아닌 값 입력 시 IllegalArgumentException이 반환된다.")
    void zeroFailTest(Long amountOfLotto) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> amountOfLottoValidator.checkAmountWithinLottoPriceRange(amountOfLotto))
                .withMessage(NOT_POSITIVE_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(longs = {1000, 10000, 2147483000})
    @DisplayName("로또 금액 (현재 기준 " + "원) 으로 나누어 떨어질 시 어떠한 에러도 반환하지 않는다.")
    void divideByLottoPrice(Long amountOfLotto) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> amountOfLottoValidator.checkDivideByLottoPrice(amountOfLotto));
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("로또 금액 (현재 기준 " + "원) 으로 나누어 떨어지지 않을 시 IllegalArgumentException이 반환된다.")
    void notDivideByLottoPrice(Long amountOfLotto) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> amountOfLottoValidator.checkDivideByLottoPrice(amountOfLotto))
                .withMessage(NOT_DIVIDE_BY_LOTTO_PRICE.getMessage());
    }
}