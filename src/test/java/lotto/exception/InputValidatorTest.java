package lotto.exception;

import static lotto.exception.ExceptionMessage.COUNT_EXCEPTION;
import static lotto.exception.ExceptionMessage.DUPLICATION_EXCEPTION;
import static lotto.exception.ExceptionMessage.INVALID_AMOUNT_FORMAT;
import static lotto.exception.ExceptionMessage.NON_NUMBER_EXCEPTION;
import static lotto.exception.ExceptionMessage.RANGE_EXCEPTION;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @DisplayName("string 입력값이 1000의 배수인지 유효성 검사하는 기능 테스트 ")
    @Test
    void isMultipleOf1000() {

        try {
            InputValidator.isMultipleOf1000("1001");

        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(INVALID_AMOUNT_FORMAT.getMessage(), e.getMessage());

        }
    }

    @DisplayName("string 입력값이 숫자인지 유효성 검사 하는 기능 테스트 ")
    @Test
    void validateStringInput() {

        try {
            InputValidator.validateStringInput("-123,");

        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(NON_NUMBER_EXCEPTION.getMessage(), e.getMessage());

        }
    }

    @DisplayName("int 입력값이 1 ~ 45의 숫자인지 유효성 검사 하는 기능 테스트 ")
    @Test
    void validateInputRange() {

        try {
            InputValidator.validateInputRange(100);

        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(RANGE_EXCEPTION.getMessage(), e.getMessage());

        }
    }

    @DisplayName("string 입력값이 1 ~ 45의 숫자인지 유효성 검사 하는 기능 테스트 ")
    @Test
    void validateStrInputRange() {

        try {
            InputValidator.validateStrInputRange("100");

        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(RANGE_EXCEPTION.getMessage(), e.getMessage());

        }
    }

    @DisplayName("중복 숫자값이 있는지 유효성 검사 하는 기능 테스트 ")
    @Test
    void hasDuplicates() {

        try {
            InputValidator.hasDuplicates(List.of(1, 2, 3, 4, 6, 6));

        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(DUPLICATION_EXCEPTION.getMessage(), e.getMessage());

        }
    }

    @DisplayName("입력값이 6개인지 유효성 검사 하는 기능 테스트 ")
    @Test
    void validateNumSize() {

        try {
            InputValidator.validateNumSize(List.of(1, 2, 3, 4, 6));

        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(COUNT_EXCEPTION.getMessage(), e.getMessage());

        }
    }


}
