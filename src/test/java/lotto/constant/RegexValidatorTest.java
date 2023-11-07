package lotto.constant;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegexValidatorTest {

    @ParameterizedTest
    @DisplayName("로또 구입 금액은 1000원 단위로 입력되어야 한다.")
    @ValueSource(strings = {"1500", "1234", "900", "50", "2023", "0", "1000g"})
    void wrongLottoBudgetInput(String budget) {
        // given
        RegexValidator validator = RegexValidator.PRICE;

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(budget));
    }

    @ParameterizedTest
    @DisplayName("구입 금액이 1000원 단위로 입력되면 에러가 발생하지 않는다.")
    @ValueSource(strings = {"1000", "40000", "1002000"})
    void lottoBudgetInput(String budget) {
        // given
        RegexValidator validator = RegexValidator.PRICE;

        // then
        assertThatCode(() -> validator.validate(budget))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("당첨 번호는 6개가 쉼표로 구분되어 공백 없이 입력되어야 한다.")
    @ValueSource(strings = {"1,2,3,4", "1,2,3,4,5,6,7", "a,b,c,d,e,f", "1, 2, 3, 4, 5, 6"})
    void wrongWinningNumberInput(String numbers) {
        // given
        RegexValidator validator = RegexValidator.COUNT;

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(numbers));
    }

    @Test
    @DisplayName("당첨 번호가 정상적으로 입력될 경우 에러가 발생하지 않는다.")
    void winningNumberInput() {
        // given
        RegexValidator validator = RegexValidator.COUNT;

        // when
        String numbers = "1,2,3,4,5,6";

        // then
        assertThatCode(() -> validator.validate(numbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 1이상 45이하가 아닐 경우 에러가 발생한다.")
    @ValueSource(ints = {0, 46, 70})
    void wrongWinningNumberInput(int number) {
        // given
        RegexValidator validator = RegexValidator.LOTTO_NUMBER;

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(String.valueOf(number)));
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 1이상 45이하일 경우 에러가 발생하지 않는다.")
    @ValueSource(ints = {1, 45, 20, 36, 7})
    void winningNumberInput(int number) {
        // given
        RegexValidator validator = RegexValidator.LOTTO_NUMBER;

        // then
        assertThatCode(() -> validator.validate(String.valueOf(number)))
                .doesNotThrowAnyException();
    }
}
