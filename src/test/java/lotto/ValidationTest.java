package lotto;

import lotto.utils.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Validation 클래스 테스트")
class ValidationTest {
    @Test
    @DisplayName("정상적인 숫자 문자열 검증")
    void 문자열_숫자_검증() {
        // 정상적인 경우, 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> Validation.validateStringToInteger("123"));
    }

    @Test
    @DisplayName("올바르지 않은 문자열 검증")
    void 문자열_숫자_검증_실패() {
        // 예외가 발생해야 하는 경우
        assertThrows(IllegalArgumentException.class, () -> Validation.validateStringToInteger("abc"));
    }

    @Test
    @DisplayName("빈 문자열 검증 실패")
    void 문자열_숫자_검증_실패_빈문자열() {
        // 예외가 발생해야 하는 경우
        assertThrows(IllegalArgumentException.class, () -> Validation.validateStringToInteger(""));
    }

    @Test
    @DisplayName("공백 문자열 검증 실패")
    void 문자열_숫자_검증_실패_공백문자열() {
        // 예외가 발생해야 하는 경우
        assertThrows(IllegalArgumentException.class, () -> Validation.validateStringToInteger(" "));
    }

    @Test
    @DisplayName("문자열과 숫자 혼합 검증 실패")
    void 문자열_숫자_검증_실패_문자열_숫자_혼합() {
        // 예외가 발생해야 하는 경우
        assertThrows(IllegalArgumentException.class, () -> Validation.validateStringToInteger("123a"));
    }

    @Test
    @DisplayName("문자열과 숫자 혼합 및 공백 검증 실패")
    void 문자열_숫자_검증_실패_문자열_숫자_혼합_공백() {
        // 예외가 발생해야 하는 경우
        assertThrows(IllegalArgumentException.class, () -> Validation.validateStringToInteger("123 a"));
    }

    @Test
    @DisplayName("숫자 범위 검증")
    void 숫자_범위_검증() {
        // 정상적인 경우, 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> Validation.validateNumberInRange(1, 1, 10));
    }

    @Test
    @DisplayName("숫자 범위 검증 실패")
    void 숫자_범위_검증_실패() {
        // 예외가 발생해야 하는 경우
        assertThrows(IllegalArgumentException.class, () -> Validation.validateNumberInRange(11, 1, 10));
    }

    @Test
    @DisplayName("숫자 배수 검증")
    void 숫자_배수_검증() {
        // 정상적인 경우, 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> Validation.validateNumberMultipleOf(10000, 1000));
    }

    @Test
    @DisplayName("숫자 배수 검증 실패")
    void 숫자_배수_검증_실패() {
        // 예외가 발생해야 하는 경우
        assertThrows(IllegalArgumentException.class, () -> Validation.validateNumberMultipleOf(1234, 1000));
    }
}
