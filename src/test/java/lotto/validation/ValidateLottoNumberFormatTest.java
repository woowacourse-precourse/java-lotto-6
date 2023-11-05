package lotto.validation;

import lotto.exception.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateLottoNumberFormatTest {

    @DisplayName("입력 받은 당첨 번호 개수가 6개가 아니라면 예외를 발생시킨다.")
    @Test
    void inputWinningNumberByInvalidNumberSize() {
        String inputWinningNumber = "1,2,3,4,5";

        assertThatThrownBy(() -> ValidateLottoNumberFormat.validate(inputWinningNumber))
                .isInstanceOf(InvalidLottoNumberSizeException.class);
    }

    @DisplayName("입력 받은 당첨 번호가 비어있다면 예외를 발생시킨다.")
    @Test
    void inputWinningNumberByBlankNumber() {
        String inputWinningNumber = "1,,3,4,5,6";

        assertThatThrownBy(() -> ValidateLottoNumberFormat.validate(inputWinningNumber))
                .isInstanceOf(InvalidBlankNumberException.class);
    }

    @DisplayName("입력 받은 당첨 번호가 올바른 로또 번호 형식이 아니라면 예외를 발생시킨다.")
    @Test
    void inputWinningNumberByInvalidLottoNumber() {
        String firstInputWinningNumber = "일,2,3,4,5,6";
        String secondInputWinningNumber = "10,20,30,40,50,60";

        assertThatThrownBy(() -> ValidateLottoNumberFormat.validate(firstInputWinningNumber))
                .isInstanceOf(InvalidLottoNumberException.class);

        assertThatThrownBy(() -> ValidateLottoNumberFormat.validate(secondInputWinningNumber))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @DisplayName("입력 받은 당첨 번호가 중복된다면 예외를 발생시킨다.")
    @Test
    void inputWinningNumberByDuplicatedNumber() {
        String inputWinningNumber = "1,1,3,4,5,6";

        assertThatThrownBy(() -> ValidateLottoNumberFormat.validate(inputWinningNumber))
                .isInstanceOf(InvalidDuplicatedNumberException.class);
    }

}