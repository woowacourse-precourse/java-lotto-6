package lotto.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class IntegerValidatorTest {

    private final int minRange = 1;
    private final int maxRange = 100;

    @Test
    public void 정수가_아닌_문자면_예외발생() {
        assertExceptionThrownForInvalidValue("k", "정수 범위의 값이 필요합니다.");
    }

    @Test
    public void 정수인_문자면_검증통과() {
        IntegerValidator.validateInteger("1");
    }

    @Test
    public void 정수가_특정수의_배수가_아니면_예외발생() {
        assertExceptionThrownForInvalidMultiple(1234, 1000, "1000의 배수인 숫자가 필요합니다.");
    }

    @Test
    public void 정수가_특정수의_배수면_정상통과() {
        IntegerValidator.validateMultipleOf(10000, 1000);
    }

    @Test
    public void 정수가_특정수의_범위내에_없으면_예외발생() {
        assertExceptionThrownForInvalidRange(101, minRange, maxRange, "정해진 범위의 숫자를 입력하세요.");
    }

    @Test
    public void 정수가_특정수의_범위내에_있으면_정상통과() {
        IntegerValidator.validateInRange(100, minRange, maxRange);
    }

    @Test
    public void 정수가_특정수보다_작으면_예외발생() {
        assertExceptionThrownForSmallerValue(0, minRange, "정해진 범위의 숫자를 입력하세요.");
    }

    @Test
    public void 정수가_특정수보다_작지않으면_정상통과() {
        IntegerValidator.validateSmaller(2, minRange);
    }

    @Test
    public void 정수가_특정수보다_크면_예외발생() {
        assertExceptionThrownForBiggerValue(101, maxRange, "정해진 범위의 숫자를 입력하세요.");
    }

    @Test
    public void 정수가_특정수보다_크지않으면_정상통과() {
        IntegerValidator.validateBigger(99, maxRange);
    }

    @Test
    public void 두_정수의_합이_정수범위를_벗어나면_예외발생() {
        assertExceptionThrownForInvalidPlusRange(1200000000, 1000000000, "정수 범위를 벗어난 값은 더할 수 없습니다.");
    }

    @Test
    public void 두_정수의_합이_정수범위를_벗어나지_않으면_정상통과_양수값() {
        IntegerValidator.validatePlusRange(2147483646, 1);
    }

    @Test
    public void 두_정수의_합이_정수범위를_벗어나지_않으면_정상통과_음수값() {
        IntegerValidator.validatePlusRange(-2147483647, -1);
    }

    private void assertExceptionThrownForInvalidValue(String input, String expectedMessage) {
        assertThatThrownBy(() -> IntegerValidator.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private void assertExceptionThrownForInvalidMultiple(int value, int multiple, String expectedMessage) {
        assertThatThrownBy(() -> IntegerValidator.validateMultipleOf(value, multiple))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private void assertExceptionThrownForInvalidRange(int value, int min, int max, String expectedMessage) {
        assertThatThrownBy(() -> IntegerValidator.validateInRange(value, min, max))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private void assertExceptionThrownForSmallerValue(int value, int min, String expectedMessage) {
        assertThatThrownBy(() -> IntegerValidator.validateSmaller(value, min))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private void assertExceptionThrownForBiggerValue(int value, int max, String expectedMessage) {
        assertThatThrownBy(() -> IntegerValidator.validateBigger(value, max))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private void assertExceptionThrownForInvalidPlusRange(int value1, int value2, String expectedMessage) {
        assertThatThrownBy(() -> IntegerValidator.validatePlusRange(value1, value2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
