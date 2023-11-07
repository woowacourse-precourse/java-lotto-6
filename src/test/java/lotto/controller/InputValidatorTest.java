package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.controller.validator.BonusNumberValidator;
import lotto.controller.validator.BudgetValidator;
import lotto.controller.validator.WinningNumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    // 구입 금액 입력 검증
    @DisplayName("구입 금액 정상 입력에 대해서 예외가 발생한다면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "5000", "8000", "12000"})
    void 구입_금액_정상_입력_테스트(String budget) {
        assertThatCode(() -> BudgetValidator.getInstance().validate(budget))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 구입 금액이 정수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10.33", "abc", "d_o_o_b", "십이만"})
    void 구입_금액_정수_입력_예외_테스트(String budget) {
        assertThatThrownBy(() -> BudgetValidator.getInstance().validate(budget))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 구입 금액이 양수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000"})
    void 구입_금액_양수_입력_예외_테스트(String budget) {
        assertThatThrownBy(() -> BudgetValidator.getInstance().validate(budget))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 구입 금액이 로또 가격(1000)으로 나누어 떨어지지 않는 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10", "100", "1100", "2023"})
    void 구입_금액_로또_가격의_배수_예외_테스트(String budget) {
        assertThatThrownBy(() -> BudgetValidator.getInstance().validate(budget))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 당첨 번호 입력 검증
    @DisplayName("당첨 번호 정상 입력에 대해서 예외가 발생한다면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "6,5,4,3,2,1"})
    void 당첨_번호_정상_입력_테스트(String winningNumbers) {
        assertThatCode(() -> WinningNumbersValidator.getInstance().validate(winningNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 당첨 번호 중에 정수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6.1", "6,5,4,3,2,1.2"})
    void 당첨_번호_정수_입력_예외_테스트(String winningNumbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.getInstance().validate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 당첨 번호 중에 1~45 사이가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,60", "1,2,50,4,5,6"})
    void 당첨_번호_숫자_범위_예외_테스트(String winningNumbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.getInstance().validate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 당첨 번호 중에 정수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,3,5,6"})
    void 당첨_번호_중복된_숫자_예외_테스트(String winningNumbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.getInstance().validate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 보너스 번호 입력 검증
    @DisplayName("사용자가 입력한 보너스 번호가 정수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"십이", "twenty"})
    void 보너스_번호_정수_입력_예외_테스트(String bonusNumber) {
        assertThatCode(() -> BonusNumberValidator.getInstance().validate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 보너스 번호가 1~45 사이가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "50"})
    void 보너스_번호_숫자_범위_예외_테스트(String bonusNumber) {
        assertThatCode(() -> BonusNumberValidator.getInstance().validate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
