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
}