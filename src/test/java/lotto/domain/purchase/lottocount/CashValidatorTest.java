package lotto.domain.purchase.lottocount;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CashValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000"})
    @DisplayName("1이상,30000이하,천원단위의 금액 입력인 경우, 정상처리합니다.")
    void 일이상의_삼만이하의_천원단위만_입력가능(String input) {
        // THEN
        CashValidator.validateCashInput.accept(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("1 이하의 정수 금액 입력인 경우, 예외 처리합니다.")
    public void 일이하의정수를입력(String input) {
        // THEN
        assertThrows(IllegalArgumentException.class, () -> CashValidator.validateCashInput.accept(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"758", "1234"})
    @DisplayName("1000원이 아닌 단위의 금액 입력인 경우, 예외 처리합니다.")
    public void 천원이아닌단위금액(String input) {
        // THEN
        assertThrows(IllegalArgumentException.class, () -> CashValidator.validateCashInput.accept(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j"})
    @DisplayName("특수문자 입력인 경우, 예외 처리합니다.")
    public void 특수문자입력(String input) {
        // THEN
        assertThrows(IllegalArgumentException.class, () -> CashValidator.validateCashInput.accept(input));
    }
}