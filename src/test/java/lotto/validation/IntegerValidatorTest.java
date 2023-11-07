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

}
