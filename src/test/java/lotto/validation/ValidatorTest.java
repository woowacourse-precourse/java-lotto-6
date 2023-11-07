package lotto.validation;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"as", "!", "나비"})
    @DisplayName("로또 구매 금액이 문자인 경우 예외 발생")
    void validateLottoAmountNumeric(String input) throws LottoException {
        assertThatThrownBy(() -> Validator.validateLottoAmountNumeric(input))
                .isInstanceOf(LottoException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 구매 금액이 null 예외 발생")
    void validateLottoAmountNumericNull() throws LottoException {
        String input = null;
        assertThatThrownBy(() -> Validator.validateLottoAmountNumeric(input))
                .isInstanceOf(LottoException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("로또 구매 금액이 공백인 경우 예외 발생")
    void testValidatedWinningNumbersFormat(String lottoNumbers) {
        assertThatThrownBy(() -> Validator.validatedWinningNumbersFormat(lottoNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(LottoException.ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"1000", "1200", "1303003", "1231231123"})
    @DisplayName("로또 구매 금액 입력이 정상인 경우") // 로또 금액이 1000원에 나누어 떨어지는지 검증은, LottoPurchaseService 에서 검사 한다.
    void validateLottoAmountNumericSuccess(String input) throws LottoException {
        assertDoesNotThrow(() -> Validator.validateLottoAmountNumeric(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"as", "!", "나비"})
    @DisplayName("로또 보너스 번호가 문자인 경우 예외 발생")
    void validateBonusNumberNumeric(String input) throws LottoException {
        assertThatThrownBy(() -> Validator.validateBonusNumberNumeric(input))
                .isInstanceOf(LottoException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 보너스 번호가 공백인 경우 예외 발생")
    void validateBonusNumberNumeric() throws LottoException {
        String input = " ";
        assertThatThrownBy(() -> Validator.validateBonusNumberNumeric(input))
                .isInstanceOf(LottoException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "14", "45", "99", "123"})
    @DisplayName("로또 보너스 번호 입력이 정상인 경우") // 숫자 여부에 대해 검사한다. 보너스 번호의 범위 검사는 보너스 번호를 생성할 때 검사한다.
    void validateBonusNumberNumericSuccess(String input) throws LottoException {
        assertDoesNotThrow(() -> Validator.validateLottoAmountNumeric(input));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5, ", "sa", "!,1,2,3,4,5", " 1, 2,3,4,5,6", " 1,2,3,4,5,6 "})
    @DisplayName("로또 당첨 번호가 검증 포맷과 다른 경우 예외 발생")
    void validatedWinningNumbersFormat(String input) throws LottoException {
        // 포맷 예시) 1,23,12,34,42,45
        assertThatThrownBy(() -> Validator.validatedWinningNumbersFormat(input))
                .isInstanceOf(LottoException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "12,1,2,3,4,5", "1,2,3,4,5,6", "1,2,3,4,5,6"})
    @DisplayName("로또 당첨 번호 검증 포맷과 같은 경우")
    void validatedWinningNumbersFormatSuccess(String input) throws LottoException {
        // 포맷 예시) 1,23,12,34,42,45
        assertDoesNotThrow(() -> Validator.validatedWinningNumbersFormat(input));
    }
}