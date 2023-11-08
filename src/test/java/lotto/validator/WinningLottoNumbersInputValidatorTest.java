package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.validator.WinningLottoNumbersInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoNumbersInputValidatorTest {
    @DisplayName("당첨 번호 입력값이 비어있을 때 예외가 발생한다.")
    @Test
    void insertWinningLottoNumbersWithBlankValue() {
        assertThatThrownBy(() -> new WinningLottoNumbersInputValidator().validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값이 구분자(,)를 포함하지 않을 때 예외가 발생한다.")
    @Test
    void insertWinningLottoNumbersWithoutDelimiter() {
        assertThatThrownBy(() -> new WinningLottoNumbersInputValidator().validate("1213"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값 중 비어있는 값이 있으면 예외가 발생한다.")
    @Test
    void insertWinningLottoNumbersWithDelimiterAndEmptyValue() {
        assertThatThrownBy(() -> new WinningLottoNumbersInputValidator().validate("1,2,3,4,,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값이 6개의 숫자로 이루어져있지 않으면 예외가 발생한다.")
    @Test
    void insertWinningLottoNumberWithNotSixNumbers() {
        assertThatThrownBy(() -> new WinningLottoNumbersInputValidator().validate("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값이 숫자형식의 입력이 포함되어 있지 않으면 예외가 발생한다.")
    @Test
    void insertWinningLottoNumberWithNotNumericType() {
        assertThatThrownBy(() -> new WinningLottoNumbersInputValidator().validate("1,2,3,40,aas,10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값 중 입력값의 상한을 초과하는 입력이 있으면 예외가 발생한다.")
    @Test
    void insertWinningLottoNumberWithNumbersExccedInputUpperLimit() {
        assertThatThrownBy(() -> new WinningLottoNumbersInputValidator().validate("1,2,3,4,50,123912057123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값 중 입력값의 하한 미만의 입력이 있으면 예외가 발생한다.")
    @Test
    void insertWinningLottoNumberWithNumbersLessThanInputLowerLimit() {
        assertThatThrownBy(() -> new WinningLottoNumbersInputValidator().validate("1,2,3,4,50,-29391233057123"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}