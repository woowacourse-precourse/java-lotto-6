package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WiningNumbersValidatorTest {
    @Test
    void 당첨번호_입력이_null이면_예외발생() {
        // given
        String winningNumbers = null;

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 당첨번호_입력이_빈문자열이면_예외발생() {
        // given
        String winningNumbers = "";

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 당첨번호가_하나라도_빈문자열이면_예외발생() {
        // given
        String winningNumbers = "1,2,3,,4,5";

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 당첨번호중_하나라도_숫자가_아닌_값이_포함되어_있으면_예외발생() {
        // given
        String winningNumbers = "1,2,3,2a,4,5";

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 당첨번호중_하나라도_int형_범위를_벗어나면_예외발생() {
        // given
        String winningNumbers = "1,2,10000000000000,4,5,6";

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 당첨번호중_하나라도_음수면_예외발생() {
        // given
        String winningNumbers = "1,2,-100000,4,5,6";

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 당첨번호의_개수가_6이_아니면_예외발생() {
        // given
        String winningNumbers = "1,2,3,4,5";

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 당첨번호에_중복되는_숫자가_있으면_예외발생() {
        // given
        String winningNumbers = "1,2,2,4,5,6";

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 당첨번호중_하나라도_범위_1이상_45이하를_벗어나면_예외발생() {
        // given
        String winningNumbers = "1,2,3,46,5,6";

        // when, then
        assertThrowOnInvalidPurchasePrice(winningNumbers);
    }

    @Test
    void 로또_구입_금액_정상값_테스트() {
        // given
        String winningNumbers = "1,2,3,4,5,6";

        // when, then
        assertNotThrowsOnValidWinningNumbers(winningNumbers);
    }

    private static void assertNotThrowsOnValidWinningNumbers(String winningNumbers) {
        assertDoesNotThrow(() -> {
            Validator.validateWinningNumbers(winningNumbers);
        });
    }

    private static void assertThrowOnInvalidPurchasePrice(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateWinningNumbers(winningNumbers);
        });
    }
}