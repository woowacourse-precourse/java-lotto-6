package lotto.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputWinningNumberValidatorTest {
    private InputWinningNumberValidator inputWinningNumberValidator;

    @BeforeEach
    public void init() {
        inputWinningNumberValidator = new InputWinningNumberValidator();
    }

    @DisplayName("당첨번호를 쉼표로 구분하지 않을때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1-2-3-4-5", "1,2,,,,", "1.2.3.4.5"})
    void 쉼표로_구분하지_않을때_예외처리_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> {
            inputWinningNumberValidator.validateWinningNumber(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 1부터 45사이의 숫자가 아닐때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,66", "1123,2,4,2,4,5", "51,52,53,5,6,7"})
    void 당첨번호가_1부터_45사이의_숫자가_아닐때_예외처리_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> {
            inputWinningNumberValidator.validateWinningNumber(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 6개 입력하지 않을때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5", "1,2,3,4,5,6,7,8"})
    void 당첨번호를_6개_입력하지_않을때_예외처리_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> {
            inputWinningNumberValidator.validateWinningNumber(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 당첨번호를 입력했을때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,2,2,3,3", "1,1,1,1,1,1"})
    void 중복된_당첨번호를_입력했을때_예외처리_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> {
            inputWinningNumberValidator.validateWinningNumber(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닐때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "2a", "%$!"})
    void 보너스_번호가_숫자가_아닐때_예외처리_테스트(String bonusNumber) {
        assertThatThrownBy(() -> {
            inputWinningNumberValidator.validateBonusNumber(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아닐때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"46", "123", "236"})
    void 보너스번호가_1부터_45_사이의_숫자가_아닐때_예외처리_테스트(String bonusNumber) {
        assertThatThrownBy(() -> {
            inputWinningNumberValidator.validateBonusNumber(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
