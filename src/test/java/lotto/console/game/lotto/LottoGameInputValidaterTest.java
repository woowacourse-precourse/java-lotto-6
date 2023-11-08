package lotto.console.game.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameInputValidaterTest {

    @DisplayName("입력된 금액 검증 - 성공 테스트")
    @Test
    public void validate_money_success_test() {
        // given
        String validMoneyInput = "5000";

        // when & then
        assertDoesNotThrow(() -> {LottoGameInputValidater.validateMoney(validMoneyInput);});
    }

    @DisplayName("입력된 금액 검증 - 실패 테스트 (천의 배수가 아님)")
    @Test
    public void validate_money_failure_test_not_multiple_thousand() {
        // given
        String invalidMoneyInput = "12200";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoGameInputValidater.validateMoney(invalidMoneyInput);
        });

        // then
        assertEquals("[ERROR] 입력값이 천의 배수가 아닙니다 : " + invalidMoneyInput + "\n다시 입력해주세요.", exception.getMessage());
    }

    @DisplayName("입력된 당첨 번호 검증 - 성공 테스트")
    @Test
    public void validate_numbers_success_test() {
        // given
        String validNumbersInput = "5,3,4,2,1,10";

        // when & then
        assertDoesNotThrow(() -> {LottoGameInputValidater.validateNumbers(validNumbersInput);});
    }

    @DisplayName("입력된 당첨 번호 검증 - 실패 테스트 (구분자 오류)")
    @Test
    public void validate_numbers_failure_test_invalid_separator() {
        // given
        String invalidNumbersInput = "5 3 4 2 1 6";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoGameInputValidater.validateNumbers(invalidNumbersInput);
        });

        // then
        assertEquals("[ERROR] 번호는 쉼표(,)를 기준으로 구분되어야 합니다 : " + invalidNumbersInput + "\n다시 입력해주세요.", exception.getMessage());
    }

    @DisplayName("입력된 당첨 번호 검증 - 실패 테스트 (중복된 숫자가 있음)")
    @Test
    public void validate_numbers_failure_test_has_duplicates() {
        // given
        String invalidNumbersInput = "5,3,4,2,1,1";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoGameInputValidater.validateNumbers(invalidNumbersInput);
        });

        // then
        assertEquals("[ERROR] 중복된 번호가 입력되어서는 안됩니다 : " + invalidNumbersInput + "\n다시 입력해주세요.", exception.getMessage());
    }

    @DisplayName("입력된 당첨 번호 검증 - 실패 테스트 (6개가 아님")
    @Test
    public void validate_numbers_failure_test_not_six() {
        // given
        String invalidNumbersInput = "5,3,4,2,1,6,7,8";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoGameInputValidater.validateNumbers(invalidNumbersInput);
        });

        // then
        assertEquals("[ERROR] 당첨 번호는 6개여야 합니다 : " + invalidNumbersInput + "\n다시 입력해주세요.", exception.getMessage());
    }

    @DisplayName("입력된 당첨 번호 검증 - 실패 테스트 (로또 번호의 범위를 벗어남")
    @Test
    public void validate_numbers_failure_out_of_range() {
        // given
        String invalidNumbersInput = "5,3,4,2,1,66";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoGameInputValidater.validateNumbers(invalidNumbersInput);
        });

        // then
        assertEquals("[ERROR] 입력값이 로또 번호의 범위를 벗어납니다 : 66\n다시 입력해주세요.", exception.getMessage());
    }

    @DisplayName("입력된 보너스 번호 검증 - 성공 테스트")
    @Test
    public void validate_number_success_test() {
        // given
        String validNumberInput = "5";

        // when & then
        assertDoesNotThrow(() -> {LottoGameInputValidater.validateNumber(validNumberInput);});
    }

    @DisplayName("입력된 보너스 번호 검증 - 실패 테스트 (로또 번호의 범위를 벗어남")
    @Test
    public void validate_number_failure_out_of_range() {
        // given
        String invalidNumberInput = "-1";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoGameInputValidater.validateNumber(invalidNumberInput);
        });

        // then
        assertEquals("[ERROR] 입력값이 로또 번호의 범위를 벗어납니다 : " + invalidNumberInput + "\n다시 입력해주세요.", exception.getMessage());
    }
}