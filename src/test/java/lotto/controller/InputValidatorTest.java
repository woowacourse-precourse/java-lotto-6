package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    // 구입 금액 입력 검증
    @DisplayName("구입 금액 정상 입력에 대해서 예외가 발생한다면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "5000", "8000", "12000"})
    void 구입_금액_정상_입력_테스트(String budget) {
        InputValidator inputValidator = new InputValidator();
        assertThatCode(() -> inputValidator.validateBudgetInput(budget))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 구입 금액이 정수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10.33", "abc", "d_o_o_b", "십이만"})
    void 구입_금액_validateInteger_예외_테스트(String budget) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateBudgetInput(budget))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 구입 금액이 양수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000"})
    void 구입_금액_validatePositiveInteger_예외_테스트(String budget) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateBudgetInput(budget))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 구입 금액이 1000으로 나누어 떨어지지 않는 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10", "100", "1100", "2023"})
    void 구입_금액_validateDividedBy1000_예외_테스트(String budget) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateBudgetInput(budget))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 당첨 번호 입력 검증
    @DisplayName("당첨 번호 정상 입력에 대해서 예외가 발생한다면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "6,5,4,3,2,1"})
    void 당첨_번호_정상_입력_테스트(String lottoTicket) {
        InputValidator inputValidator = new InputValidator();
        assertThatCode(() -> inputValidator.validateLottoTicketInput(lottoTicket))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 당첨 번호 중에 정수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6.1", "6,5,4,3,2,1.2"})
    void 당첨_번호_validateInteger_예외_테스트(String lottoTicket) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateLottoTicketInput(lottoTicket)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 당첨 번호 중에 1~45 사이가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,60", "1,2,50,4,5,6"})
    void 당첨_번호_validateNumberInRange_예외_테스트(String lottoTicket) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateLottoTicketInput(lottoTicket)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 당첨 번호 중에 정수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,3,5,6"})
    void 당첨_번호_validateDuplication_예외_테스트(String lottoTicket) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateLottoTicketInput(lottoTicket)).isInstanceOf(
                IllegalArgumentException.class);
    }

    // 보너스 번호 입력 검증
    @DisplayName("사용자가 입력한 보너스 번호가 정수가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"십이", "twenty"})
    void 보너스_번호_validateInteger_예외_테스트(String bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        InputValidator inputValidator = new InputValidator();
        assertThatCode(() -> inputValidator.validateBonusNumberInput(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 보너스 번호가 1~45 사이가 아닌 값이 들어왔을 때 예외를 발생시키지 않으면 테스트는 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "50"})
    void 보너스_번호_validateNumberInRange_예외_테스트(String bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        InputValidator inputValidator = new InputValidator();
        assertThatCode(() -> inputValidator.validateBonusNumberInput(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
