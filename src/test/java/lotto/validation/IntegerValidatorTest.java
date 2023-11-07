package lotto.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class IntegerValidatorTest {

    private final int minRange = 1;
    private final int maxRange = 100;

    @Test
    public void 정수가_아닌_문자면_예외발생() {
        // Given
        String nonInteger = "k";

        // When && Then
        assertThatThrownBy(() -> IntegerValidator.validateInteger(nonInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수 범위의 값이 필요합니다.");
    }

    @Test
    public void 정수인_문자면_검증통과() {
        // Given
        String integer = "1";

        // When
        IntegerValidator.validateInteger(integer);

        // Then

    }

    @Test
    public void 정수가_특정수의_배수가_아니면_예외발생() {
        // Given
        int nonMultipleOfThousand = 1234;

        // When && Then
        assertThatThrownBy(() -> IntegerValidator.validateMultipleOf(
                nonMultipleOfThousand,1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000의 배수인 숫자가 필요합니다.");
    }

    @Test
    public void 정수가_특정수의_배수면_정상통과() {
        // Given
        int nonMultipleOfThousand = 10000;

        // When
        IntegerValidator.validateMultipleOf(nonMultipleOfThousand,1000);

        // Then

    }

    @Test
    public void 정수가_특정수의_범위내에_없으면_예외발생() {
        // Given
        int outOfRangeNumber = 101;

        // When && Then
        assertThatThrownBy(() -> IntegerValidator.validateInRange(
                outOfRangeNumber, minRange, maxRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정해진 범위의 숫자를 입력하세요.");
    }

    @Test
    public void 정수가_특정수의_범위내에_있으면_정상통과() {
        // Given
        int inRangeNumber = 100;


        // When
        IntegerValidator.validateInRange(inRangeNumber, minRange, maxRange);

        // Then

    }

    @Test
    public void 정수가_특정수보다_작으면_예외발생() {
        // Given
        int smallerNumber = 0;

        // When && Then
        assertThatThrownBy(() -> IntegerValidator.validateSmaller(
                smallerNumber, minRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정해진 범위의 숫자를 입력하세요.");
    }

    @Test
    public void 정수가_특정수보다_작지않으면_정상통과() {
        // Given
        int nonSmallerNumber = 2;

        // When
        IntegerValidator.validateSmaller(nonSmallerNumber, minRange);

        // Then

    }

    @Test
    public void 정수가_특정수보다_크면_예외발생() {
        // Given
        int biggerNumber = 101;

        // When && Then
        assertThatThrownBy(() -> IntegerValidator.validateBigger(
                biggerNumber, maxRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정해진 범위의 숫자를 입력하세요.");
    }

    @Test
    public void 정수가_특정수보다_크지않으면_정상통과() {
        // Given
        int nonBiggerNumber = 99;

        // When
        IntegerValidator.validateBigger(nonBiggerNumber, maxRange);

        // Then

    }

    @Test
    public void 두_정수의_합이_정수범위를_벗어나면_예외발생() {
        // Given
        int integer1 = 1200000000;
        int integer2 = 1000000000;

        // When && Then
        assertThatThrownBy(() -> IntegerValidator.validatePlusRange(
                integer1, integer2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수 범위를 벗어난 값은 더할 수 없습니다.");
    }

    @Test
    public void 두_정수의_합이_정수범위를_벗어나지_않으면_정상통과_양수값() {
        // Given
        int integer1 = 2147483646;
        int integer2 = 1;

        // When
        IntegerValidator.validatePlusRange(integer1, integer2);

        // Then

    }

    @Test
    public void 두_정수의_합이_정수범위를_벗어나지_않으면_정상통과_음수값() {
        // Given
        int integer1 = -2147483647;
        int integer2 = -1;

        // When
        IntegerValidator.validatePlusRange(integer1, integer2);

        // Then

    }
}
