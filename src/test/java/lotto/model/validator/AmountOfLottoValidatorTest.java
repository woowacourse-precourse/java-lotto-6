package lotto.model.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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
        assertThatIllegalArgumentException().isThrownBy(
                () -> amountOfLottoValidator.checkType(amountOfLotto));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648"})
    @DisplayName("Integer 자료형이 아닐 경우 IllegalArgumentException이 반환된다.")
    void biggerThanIntegerMaxFailTest(String amountOfLotto) {
        // given
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> amountOfLottoValidator.checkType(amountOfLotto));
    }

    @ParameterizedTest
    @ValueSource(ints = {1000})
    @DisplayName("양수 입력 시 어떠한 에러도 반환되지 않는다.")
    void integerSuccessTest(int amountOfLotto) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> amountOfLottoValidator.checkRange(amountOfLotto));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    @DisplayName("양수가 아닌 값 입력 시 IllegalArgumentException이 반환된다.")
    void zeroFailTest(int amountOfLotto) {
        // given
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> amountOfLottoValidator.checkRange(amountOfLotto));
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 2147483000})
    @DisplayName("로또 금액 (현재 기준 " + "원) 으로 나누어 떨어질 시 어떠한 에러도 반환하지 않는다.")
    void divideByLottoPrice(int amountOfLotto) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> amountOfLottoValidator.checkDivideByLottoPrice(amountOfLotto));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("로또 금액 (현재 기준 " + "원) 으로 나누어 떨어지지 않을 시 IllegalArgumentException이 반환된다.")
    void notDivideByLottoPrice(int amountOfLotto) {
        // given
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> amountOfLottoValidator.checkDivideByLottoPrice(amountOfLotto));
    }
}