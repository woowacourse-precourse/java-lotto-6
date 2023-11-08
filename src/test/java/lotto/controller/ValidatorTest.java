package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.view.OutputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {

    @ParameterizedTest
    @CsvSource({"아아, [ERROR] 숫자가 아닙니다.", "-12, [ERROR] 양의 정수가 아닙니다.", "1002, [ERROR] 1000의 단위가 아닙니다."})
    void 구매금액_검증테스트(String playerInput, String expectedErrorMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isBuyAmountValid(playerInput);
        });

        String actualErrorMessage = exception.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void 로또당첨번호_검증테스트_숫자가_아닐경우() {
        String playerInput = "s,s,s,s,s,s";
        String expectedErrorMessage = "[ERROR] 숫자가 아닙니다.";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isValidAnswerLottoNumbers(playerInput);
        });

        String actualErrorMessage = exception.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void 로또당첨번호_검증테스트_6개가_아닐경우() {
        String playerInput = "1,2,3,4,5,6,7";
        String expectedErrorMessage = "[ERROR] 쉼표로 구분했을 때 6개가 아닙니다.";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isValidAnswerLottoNumbers(playerInput);
        });

        String actualErrorMessage = exception.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void 로또당첨번호_검증테스트_쉼표가_없을경우() {
        String playerInput = "1-3-4-5-6-7";
        String expectedErrorMessage = "[ERROR] 쉼표로 구분했을 때 6개가 아닙니다.";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isValidAnswerLottoNumbers(playerInput);
        });

        String actualErrorMessage = exception.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void 로또당첨번호_검증테스트_숫자_범위_넘친경우() {
        String playerInput = "1,350,4,5,6,7";
        String expectedErrorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isValidAnswerLottoNumbers(playerInput);
        });

        String actualErrorMessage = exception.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void 로또당첨번호_검증테스트_중복된_경우() {
        String playerInput = "1,4,4,5,6,7";
        String expectedErrorMessage = "[ERROR] 중복된 숫자가 존재합니다.";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isValidAnswerLottoNumbers(playerInput);
        });

        String actualErrorMessage = exception.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}