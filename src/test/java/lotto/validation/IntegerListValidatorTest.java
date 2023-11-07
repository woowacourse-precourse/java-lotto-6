package lotto.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

public class IntegerListValidatorTest {

    @Test
    public void 정수리스트에_중복된값이_있으면_예외처리() {
        // Given
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 4);

        // When && Then
        assertThatThrownBy(() -> IntegerListValidator.validateDuplicated(numbersWithDuplicates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 값은 입력할 수 없습니다.");
    }

    @Test
    public void 정수리스트에_중복된값이_없으면_정상통과() {
        // Given
        List<Integer> numbersWithoutDuplicates = Arrays.asList(1, 2, 3, 4, 5);

        // When
        IntegerListValidator.validateDuplicated(numbersWithoutDuplicates);

        // Then

    }

}